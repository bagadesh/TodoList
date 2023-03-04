package com.bagadesh.tasks

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun AddTaskButton(
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
            contentColor = MaterialTheme.colors.surface,
            backgroundColor = MaterialTheme.colors.surface
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "",
            tint = MaterialTheme.colors.onPrimary
        )
        Text(
            text = "Add task",
            color = MaterialTheme.colors.onPrimary
        )
    }
}