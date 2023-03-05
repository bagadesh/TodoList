package com.bagadesh.projects.ui.addProject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
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
import com.bagadesh.baseui.components.date.DateSelection
import com.bagadesh.baseui.components.SheetSaveButton
import com.bagadesh.baseui.components.SheetTextField
import com.bagadesh.baseui.components.SheetTitle
import com.bagadesh.baseui.theme.TodoListTheme
import com.bagadesh.baseui.uiState.UIState
import com.bagadesh.baseui.uiState.UIStatePark
import com.bagadesh.projects.ui.projectType.ProjectTypesUI

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun AddProjectUI() {
    val projectTypeVm = hiltViewModel<ProjectTypeViewModel>()
    val projectTypes by projectTypeVm.allProjectTypes.collectAsState()
    AddProjectHomeUI(
        projectTypes = projectTypes,
        onSaveClick = {

        }
    )
}

@Composable
fun AddProjectHomeUI(
    projectTypes: UIState<List<String>>,
    onSaveClick: () -> Unit
) {
    var projectName: String by remember { mutableStateOf("") }
    var projectType: String by remember { mutableStateOf("") }
    var dueDate: String by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background)
    ) {
        SheetTitle(
            text = "Create a new project",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
        )
        SheetTextField(
            value = projectName,
            onValueChange = {
                projectName = it
            }
        )
        DateSelection {
            dueDate = it
        }
        SheetTitle(
            text = "Project type",
            modifier = Modifier.padding(top = 10.dp, start = 20.dp),
        )
        UIStatePark(state = projectTypes) {
            ProjectTypesUI(
                modifier = Modifier,
                list = it,
                selectedText = "",
                onClick = { project ->
                    projectType = project
                }
            )
        }
        SheetSaveButton(
            text = "Save Project"
        ) {
            onSaveClick()
        }
    }
}

@Preview
@Composable
fun AddProjectUIPreview() {
    TodoListTheme {
        AddProjectHomeUI(
            projectTypes = UIState.Success(listOf()),
            onSaveClick = {

            }
        )
    }
}