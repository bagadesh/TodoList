package com.baga.todolist.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.bagadesh.projects.ui.addProject.AddProjectUI
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

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            MaterialColorUI()
            DateRowUI(dRows)

            UIStatePark(state = projects) {
                ProjectHomeUI(
                    projectList = it.result,
                    addProjectClick = addProjectClick
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
        AddTaskButton(modifier = Modifier.align(Alignment.BottomCenter)) {
            addTaskClick()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun Home() {
    val scope = rememberCoroutineScope()
    val addTaskState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val homeVm = hiltViewModel<HomeViewModel>()
    ModalBottomSheetLayout(
        sheetState = addTaskState,
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
                                addTaskState.hide()
                            }
                        }
                    }
                }

                ADD_PROJECT -> {
                    AddProjectUI()
                }
            }
        }) {
        HomeView(
            addTaskClick = {
                homeVm.bottomSheetType.value = ADD_TASK
                scope.launch {
                    addTaskState.show()
                }
            },
            addProjectClick = {
                homeVm.bottomSheetType.value = ADD_PROJECT
                scope.launch {
                    addTaskState.show()
                }
            }
        )
    }
}

