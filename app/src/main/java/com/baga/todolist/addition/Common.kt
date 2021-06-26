package com.baga.todolist.addition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.baga.todolist.home.dateRow.DateRow
import com.baga.todolist.home.projects.ProjectHome
import com.baga.todolist.home.thingsToDo.ThingsTodo
import com.baga.todolist.home.ui.AddTaskButton
import com.baga.todolist.ui.theme.CardBackground
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddTaskBottomSheet(
    addTaskState: BottomSheetScaffoldState,
    content: @Composable (PaddingValues) -> Unit
) {
    val a = MaterialTheme.colors.background
    var bContentColor by remember {
        mutableStateOf(a)
    }
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = addTaskState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Transparent),
            ) {
                AddTask {
                    scope.launch {
                        bContentColor = Color.Black
                        addTaskState.drawerState.close()
                    }
                }
            }

        },
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(0.dp),
        sheetBackgroundColor = Color.Transparent,
        modifier = Modifier.padding(10.dp),
        sheetElevation = 0.dp,
        contentColor = Color.Black
    ) {
        content(it)
    }
}