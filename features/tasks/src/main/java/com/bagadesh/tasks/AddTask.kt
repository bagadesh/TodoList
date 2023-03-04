@file:OptIn(ExperimentalLayoutApi::class)

package com.bagadesh.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bagadesh.tasks.ui.CircleItem
import com.bagadesh.tasks.ui.DateDisplayView

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
        Text(
            text = "Create a new task",
            color = MaterialTheme.colors.onPrimary,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 20.dp, start = 20.dp),
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = taskName,
            onValueChange = {
                taskName = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
        )
        // Date Sections
        val list = listOf("Tomorrow", "Today", "Another Date")
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            list.forEach {
                DateDisplayView(title = it)
            }
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
    Button(
        onClick = {
            //saveButton.invoke()
        }, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colors.surface,
            backgroundColor = MaterialTheme.colors.surface
        )
    ) {
        Text(text = "Save task", color = MaterialTheme.colors.onPrimary)
    }
}


@Preview
@Composable
private fun AddTaskPreview() {
    AddTask {

    }
}