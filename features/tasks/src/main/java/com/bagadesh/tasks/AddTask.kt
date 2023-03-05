@file:OptIn(ExperimentalLayoutApi::class)

package com.bagadesh.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bagadesh.baseui.components.date.DateSelection
import com.bagadesh.baseui.components.SheetSaveButton
import com.bagadesh.baseui.components.SheetTextField
import com.bagadesh.baseui.components.SheetTitle
import com.bagadesh.baseui.theme.TodoListTheme
import com.bagadesh.tasks.ui.CircleItem

@Composable
fun AddTask(
    saveButton: () -> Unit
) {
    var taskName: String by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background)
    ) {
        SheetTitle(
            text = "Create a new task",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            )
        SheetTextField(
            value = taskName,
            onValueChange = {
                taskName = it
            }
        )
        DateSelection {

        }
        Text(
            text = "Participants",
            color = MaterialTheme.colors.onPrimary,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontWeight = FontWeight.Bold
        )
        val list2 = listOf("We", "Me")
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            list2.forEach {
                CircleItem(title = it)
            }
            CircleItem(title = "Add",imageVector = Icons.Outlined.Add)
        }
        SaveTask()
    }
}

@Preview
@Composable
fun SaveTask() {
    SheetSaveButton(
        text = "Save task"
    ) {

    }
}


@Preview
@Composable
private fun AddTaskPreview() {
    TodoListTheme {
        AddTask {

        }
    }
}