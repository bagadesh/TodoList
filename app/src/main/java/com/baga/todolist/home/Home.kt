package com.baga.todolist.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.baga.presentation.HomeViewModel
import com.baga.todolist.addition.AddTask
import com.baga.todolist.home.dateRow.DateRow
import com.baga.todolist.home.projects.ProjectHome
import com.baga.todolist.home.thingsToDo.ThingsTodo
import com.baga.todolist.home.ui.AddTaskButton
import com.baga.todolist.home.ui.MaterialColorUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HomeView(addTaskState: ModalBottomSheetState, scope: CoroutineScope) {
    val viewModel: HomeViewModel = viewModel()
    val dRows = viewModel.getDates().collectAsLazyPagingItems()
    val things = viewModel.getThingsList().toMutableStateList()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            MaterialColorUI()
            DateRow(dRows)
            ProjectHome()
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
            scope.launch {
                addTaskState.show()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun Home() {
    val scope = rememberCoroutineScope()
    val addTaskState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    ModalBottomSheetLayout(
        sheetState = addTaskState,
        sheetShape = RoundedCornerShape(5.dp),
        sheetBackgroundColor = Color.Transparent,
        sheetContent = {
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
        }) {
        HomeView(addTaskState = addTaskState, scope = scope)
    }
}

