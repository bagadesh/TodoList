package com.bagadesh.projects.ui.addProject

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bagadesh.baseui.components.SheetSaveButton
import com.bagadesh.baseui.components.SheetTextField
import com.bagadesh.baseui.components.SheetTitle
import com.bagadesh.baseui.components.date.DateSelection
import com.bagadesh.baseui.theme.TodoListTheme
import com.bagadesh.baseui.uiState.UIStatePark
import com.bagadesh.projects.route.ProjectRoutes.addProjectScreenRoute
import com.bagadesh.projects.route.ProjectRoutes.selectProjectTypeRoute
import com.bagadesh.projects.state.rememberProjectState
import com.bagadesh.projects.ui.addProject.AddProjectConstants.EMPTY_PROJECT_NAME
import com.bagadesh.projects.ui.projectType.ProjectTypesUI
import com.bagadesh.projects.ui.projectType.SelectProjectTypeUI
import com.bagadesh.projects.viewModel.ProjectViewModel

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun AddProjectRoute(projectVm: ProjectViewModel, onBackPress: () -> Unit) {
    val projectTypeVm = hiltViewModel<ProjectTypeViewModel>()
    val projectTypes by projectTypeVm.allProjectTypes.collectAsState()
    val navController = rememberNavController()
    val projectState = rememberProjectState(
        addProjectTypeToDB = { projectTypeVm.doneAction(it) },
        navController = navController
    )
    BackHandler {
        onBackPress()
    }
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxWidth(),
        startDestination = addProjectScreenRoute
    ) {
        composable(addProjectScreenRoute) {
            ProjectBackground {
                var projectName: String by remember { projectVm.projectName }
                var projectType: String by remember { projectVm.selectedProjectType }
                var dueDate: String by remember { projectVm.dueDate }

                AddProjectHomeUI(
                    projectName = projectName,
                    projectNameClick = {
                        projectName = it
                    },
                    projectTypeContent = {
                        UIStatePark(state = projectTypes) {

                            LaunchedEffect(key1 = Unit, block = {
                                projectVm.selectedProjectType.value = it.firstOrNull().orEmpty()
                            })

                            ProjectTypesUI(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                                list = it,
                                selectedText = projectType,
                                onClick = {
                                    projectType = it
                                },
                                doneAction = {
                                    projectState.addProjectType(it)
                                },
                                showOtherClick = {
                                    projectState.openSelectProjectTypes()
                                }
                            )
                        }
                    },
                    dateSelectionContent = {
                        DateSelection {
                            dueDate = it
                        }
                    },
                    onProjectSaveClick = {
                        projectVm.addProject(
                            title = projectName,
                            projectType = projectType,
                            dueDate = dueDate
                        )
                        onBackPress()
                    },
                )
            }

        }
        composable(selectProjectTypeRoute) {
            ProjectBackground(modifier = Modifier.padding(top = 20.dp)) {
                UIStatePark(state = projectTypes) {
                    SelectProjectTypeUI(
                        selectedProjectType = remember { projectVm.selectedProjectType }.value,
                        modifier = Modifier.padding(10.dp),
                        list = it,
                        onClick = {
                            projectVm.selectedProjectType.value = it
                            projectState.backPress()
                        },
                        backClick = {
                            projectState.backPress()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ProjectBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier then Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background)
    ) {
        content()
    }
}

@Composable
fun AddProjectHomeUI(
    projectName: String,
    projectNameClick: (String) -> Unit,
    onProjectSaveClick: () -> Unit,
    projectTypeContent: @Composable () -> Unit,
    dateSelectionContent: @Composable () -> Unit,
) {
    var projectNameError by remember { mutableStateOf("") }

    fun validateAddProject(): Boolean {
        // Validate ProjectName
        if (projectName.isEmpty()) {
            projectNameError = EMPTY_PROJECT_NAME
            return false
        }
        return true
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        SheetTitle(
            text = "Create a new project",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
        )
        SheetTextField(
            modifier = Modifier.padding(20.dp),
            value = projectName,
            onValueChange = {
                projectNameClick(it)
                //Validation Logic for ProjectName

            },
            isError = projectNameError.isNotEmpty(),
            errorText = projectNameError
        )
        dateSelectionContent()
        SheetTitle(
            text = "Project type",
            modifier = Modifier.padding(top = 10.dp, start = 20.dp),
        )
        projectTypeContent()
        SheetSaveButton(
            text = "Save Project"
        ) {
            if (validateAddProject()) {
                onProjectSaveClick()
            }
        }
    }
}

@Preview
@Composable
fun AddProjectUIPreview() {
    TodoListTheme {

    }
}