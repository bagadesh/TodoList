@file:OptIn(ExperimentalAnimationApi::class)

package com.baga.todolist.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.baga.todolist.home.BottomSheetType.*
import com.baga.todolist.home.dateRow.DateRowUI
import com.baga.todolist.home.viewModel.HomeViewModel
import com.bagadesh.baseui.MaterialColorUI
import com.bagadesh.baseui.uiState.UIStatePark
import com.bagadesh.projects.ui.ProjectHomeUI
import com.bagadesh.projects.ui.addProject.AddProjectRoute
import com.bagadesh.projects.ui.bottomBar.ProjectSelectedBottomBar
import com.bagadesh.projects.viewModel.ProjectViewModel
import com.bagadesh.tasks.AddTask
import com.bagadesh.tasks.AddTaskButton
import com.bagadesh.tasks.ui.ThingsTodo
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HomeView(
    addTaskClick: () -> Unit,
    addProjectClick: () -> Unit
) {
    val viewModel: HomeViewModel = viewModel()
    val projectVm = hiltViewModel<ProjectViewModel>()

    val dRows = viewModel.getDates().collectAsLazyPagingItems()
    val things = viewModel.getThingsList().toMutableStateList()

    val projects by projectVm.allProjectsState.collectAsState()
    val selectedProjectItems by projectVm.selectedProjects.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            MaterialColorUI()
            DateRowUI(dRows)

            UIStatePark(state = { projects }) {
                ProjectHomeUI(
                    projectList = it.result,
                    addProjectClick = addProjectClick,
                    onClick = { projectId ->
                        projectVm.clickProjectItem(projectId = projectId)
                    },
                    onLongClick = { projectId ->
                        projectVm.longClickProjectItem(projectId)
                    },
                    selectedProjectItems = { selectedProjectItems }
                )
            }

            ThingsTodo(things) { todo, checked ->
                viewModel.onCheckBoxClick(todo)
                things.find {
                    it.todoId == todo.todoId
                }?.let {
                    it.isChecked = checked
                    things[things.indexOf(it)] = it
                }
            }
        }
        HomeBottomBarUI(
            modifier = Modifier.align(Alignment.BottomCenter),
            showSelectionBar = {
                selectedProjectItems.isNotEmpty()
            },
            selectionBarContent = {
                ProjectSelectedBottomBar(
                    modifier = Modifier,
                    deleteClick = projectVm::deleteSelectedProjects,
                    selectAllClick = projectVm::selectAllProjects,
                    closeClick = projectVm::closeButtonClick,
                )
            },
            addTaskContent = {
                AddTaskButton(onClick = addTaskClick)
            }
        )
    }
}

@Composable
fun HomeBottomBarUI(
    modifier: Modifier = Modifier,
    showSelectionBar: () -> Boolean,
    deleteSelectedProjects: () -> Unit,
    addTaskClick: () -> Unit,
    selectAllClick: () -> Unit,
    closeClick: () -> Unit,
) {
    AnimatedVisibility(modifier = modifier, visible = showSelectionBar()) {
        ProjectSelectedBottomBar(
            modifier = Modifier,
            deleteClick = deleteSelectedProjects,
            selectAllClick = selectAllClick,
            closeClick = closeClick
        )
    }
    AnimatedVisibility(modifier = modifier, visible = !showSelectionBar()) {
        AddTaskButton(onClick = addTaskClick)
    }
}

@Composable
fun HomeBottomBarUI(
    modifier: Modifier = Modifier,
    showSelectionBar: () -> Boolean,
    selectionBarContent: @Composable () -> Unit,
    addTaskContent: @Composable () -> Unit,
) {
    AnimatedVisibility(modifier = modifier, visible = showSelectionBar()) {
        selectionBarContent()
    }
    AnimatedVisibility(modifier = modifier, visible = !showSelectionBar()) {
        addTaskContent()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun Home() {
    val scope = rememberCoroutineScope()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true)
    val homeVm = hiltViewModel<HomeViewModel>()
    val projectVm = hiltViewModel<ProjectViewModel>()
    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = RoundedCornerShape(5.dp),
        sheetBackgroundColor = Color.Transparent,
        sheetContent = {

            when (homeVm.bottomSheetType.value) {
                ADD_TASK -> {
                    Box(
                        modifier = Modifier
                            .padding(10.dp),
                    ) {
                        AddTask {
                            scope.launch {
                                bottomState.hide()
                            }
                        }
                    }
                }

                ADD_PROJECT -> {
                    AddProjectRoute(
                        projectVm = projectVm,
                        onBackPress = {
                            scope.launch {
                                bottomState.hide()
                            }
                        }
                    )
                }
            }
        }) {
        HomeView(
            addTaskClick = {
                homeVm.bottomSheetType.value = ADD_TASK
                scope.launch {
                    bottomState.show()
                }
            },
            addProjectClick = {
                homeVm.bottomSheetType.value = ADD_PROJECT
                scope.launch {
                    bottomState.show()
                }
            }
        )
    }
}

