package com.baga.todolist.addition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun AddTaskPreview() {
    AddTask {

    }
}

@Composable
fun AddTask(
    saveButton: () -> Unit
) {
    var taskName: String by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .requiredHeight(100.dp)
            .background(MaterialTheme.colors.background)
            .padding(10.dp)
    ) {
        Text(
            text = "Create a new task",
            color = MaterialTheme.colors.onSecondary,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 20.dp),
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = taskName,
            onValueChange = {
                taskName = it
            },
            modifier = Modifier.background(Color.Transparent),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            )
        )
    }
}