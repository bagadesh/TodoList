@file:OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)

package com.bagadesh.projects.ui.projectType

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baga.domain.debug.printInLogger
import com.bagadesh.baseui.theme.TodoListPreviewBackground

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun ProjectTypesUI(
    modifier: Modifier = Modifier,
    list: List<String>,
    selectedText: String,
    onClick: (String) -> Unit,
    doneAction: (String) -> Unit,
    showOtherClick: () -> Unit,
) {
    LaunchedEffect(key1 = Unit, block = {
        printInLogger("ProjectTypesUI -> count = ${list.size}")
    })
    var showAddDialog by remember { mutableStateOf(false) }
    val modifiedList = remember(list) { if (list.size > 6) list.subList(0, 6) else list }
    val isSelectedTextPresentInModifiedList = remember(selectedText, modifiedList) {
        if (selectedText.isEmpty()) {
            return@remember true
        } else {
            return@remember modifiedList.contains(selectedText)
        }
    }

    Column(modifier = modifier then Modifier.fillMaxWidth()) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            modifiedList.forEach {
                ProjectItemType(
                    modifier = Modifier.padding(10.dp),
                    text = it,
                    selected = remember(selectedText) { selectedText == it }
                ) {
                    onClick(it)
                }
            }
            if (!isSelectedTextPresentInModifiedList) {
                ProjectItemType(
                    modifier = Modifier.padding(10.dp),
                    text = selectedText,
                    selected = true
                ) {
                    onClick(selectedText)
                }
            }
            if (list.size > 6) {
                ClipRoundBackground(
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        showOtherClick()
                    },
                    text = "Others",
                    textColor = MaterialTheme.colors.onSurface,
                    backgroundColor = MaterialTheme.colors.primary.copy(alpha = .3f)
                )
            }

            ClipRoundBackground(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    showAddDialog = true
                },
                text = "Add",
                textColor = MaterialTheme.colors.surface,
                backgroundColor = MaterialTheme.colors.primary.copy(alpha = .6f)
            )
        }
    }

    AddProjectTypeDialog(
        modifier = Modifier,
        showDialog = { showAddDialog },
        hideDialog = {
            showAddDialog = false
        },
        addProjectType = {
            doneAction(it)
            showAddDialog = false
        }
    )

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
    ClipRoundBackground(
        modifier = modifier,
        onClick = onClick,
        text = text,
        textColor = textColor,
        backgroundColor = backgroundColor
    )
}

@Composable
fun ClipRoundBackground(
    textColor: Color = MaterialTheme.colors.onSurface,
    backgroundColor: Color = MaterialTheme.colors.surface,
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier then Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = backgroundColor)
            .clickable { onClick() }
            .padding(10.dp)
    ) {
        Text(text = text, color = textColor)
    }
}

@Preview
@Composable
fun ProjectItemTypePreview() {
    TodoListPreviewBackground {
        ProjectItemType(text = "Sample", selected = false) {

        }
    }
}

@Preview
@Composable
fun ProjectItemTypeSelectedPreview() {
    TodoListPreviewBackground {
        ProjectItemType(text = "Sample", selected = true) {

        }
    }
}

@Preview
@Composable
fun ProjectTypesUIPreview() {
    TodoListPreviewBackground {
        ProjectTypesUI(
            list = mutableListOf<String>().apply {
                repeat(10) {
                    add("Sample $it")
                }
            },
            selectedText = "Sample 2",
            onClick = {

            },
            doneAction = {

            },
            showOtherClick = {}
        )
    }
}