package com.bagadesh.projects.ui.projectType

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.bagadesh.baseui.components.SheetTextField
import com.bagadesh.baseui.components.SheetTitle
import com.bagadesh.baseui.theme.TodoListPreviewBackground

/**
 * Created by bagadesh on 10/03/23.
 */

@Composable
fun AddProjectTypeDialog(
    modifier: Modifier = Modifier,
    showDialog: () -> Boolean,
    hideDialog: () -> Unit,
    addProjectType: (String) -> Unit,
) {
    if (showDialog()) {
        val focusManager = LocalFocusManager.current
        Dialog(onDismissRequest = { hideDialog() }) {

            var sheetTextField by remember { mutableStateOf("") }

            Column(
                modifier = modifier then Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.surface)
                    .padding(10.dp)
            ) {
                SheetTitle(text = "Add Project type", modifier = Modifier.padding(0.dp))
                SheetTextField(
                    modifier = Modifier.padding(vertical = 10.dp),
                    value = sheetTextField, onValueChange = { sheetTextField = it },
                    placeholder = {
                        Text(text = "add project type", color = MaterialTheme.colors.onSurface)
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                Row(
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(onClick = { hideDialog()}, colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)) {
                        Text(text = "Cancel", color = MaterialTheme.colors.onSurface)
                    }
                    Button(onClick = { addProjectType(sheetTextField) }) {
                        Text(text = "Confirm", color = MaterialTheme.colors.surface)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AddProjectTypeDialogPreview() {
    TodoListPreviewBackground(darkTheme = false) {
        AddProjectTypeDialog(
            showDialog = { true },
            hideDialog = {},
            addProjectType = {}
        )
    }
}