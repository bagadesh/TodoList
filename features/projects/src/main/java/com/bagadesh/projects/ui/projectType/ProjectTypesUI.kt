@file:OptIn(ExperimentalLayoutApi::class)

package com.bagadesh.projects.ui.projectType

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bagadesh.baseui.components.SheetTextField
import com.bagadesh.baseui.theme.TodoListTheme

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun ProjectTypesUI(
    modifier: Modifier = Modifier,
    list: List<String>,
    selectedText: String,
    onClick: (String) -> Unit
) {
    var sheetTextField by remember { mutableStateOf("") }
    val modifiedList = remember { if (list.size > 6) list.subList(0, 6) else list }
    Column(modifier = modifier then Modifier.fillMaxWidth()) {
        SheetTextField(
            value = sheetTextField, onValueChange = { sheetTextField = it },
            placeholder = {
                Text(text = "Search")
            }
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            modifiedList.forEach {
                ProjectItemType(
                    modifier = Modifier.padding(10.dp),
                    text = it,
                    selected = remember { selectedText == it }
                ) {
                    onClick(it)
                }
            }
        }
        Row {
            ProjectItemType(
                modifier = Modifier.padding(10.dp),
                text = "Add",
                selected = false
            ) {

            }
            if (list.size > 6) {
                ProjectItemType(
                    modifier = Modifier.padding(10.dp),
                    text = "Others",
                    selected = false
                ) {

                }
            }
        }
    }
}

@Composable
fun ProjectItemType(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val textColor: Color
    val backgroundColor: Color
    when (selected) {
        true -> {
            textColor = MaterialTheme.colors.background
            backgroundColor = MaterialTheme.colors.primary
        }

        false -> {
            textColor = MaterialTheme.colors.onSurface
            backgroundColor = MaterialTheme.colors.surface
        }
    }
    Box(
        modifier = modifier then Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = backgroundColor)
            .padding(10.dp)
            .clickable { onClick() }
    ) {
        Text(text = text, color = textColor)
    }
}

@Preview
@Composable
fun ProjectItemTypePreview() {
    TodoListTheme {
        ProjectItemType(text = "Sample", selected = false) {

        }
    }
}

@Preview
@Composable
fun ProjectItemTypeSelectedPreview() {
    TodoListTheme {
        ProjectItemType(text = "Sample", selected = true) {

        }
    }
}

@Preview
@Composable
fun ProjectTypesUIPreview() {
    TodoListTheme {
        Column(modifier = Modifier.background(MaterialTheme.colors.background)) {
            ProjectTypesUI(
                list = mutableListOf<String>().apply {
                    repeat(10) {
                        add("Sample $it")
                    }
                },
                selectedText = "Sample 2",
                onClick = {

                }
            )
        }
    }
}