package com.baga.todolist.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.baga.domain.entity.thingsTodo.Todo

@Composable
fun AddTaskButton(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(100.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFFF8FAFB),
            backgroundColor = Color(0xFFF8FAFB)
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "",
            tint = Color.Black
        )
        Text(
            text = title,
            color = MaterialTheme.colors.onSecondary
        )
    }
}