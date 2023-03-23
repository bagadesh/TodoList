package com.bagadesh.baseui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bagadesh.baseui.theme.TodoListPreviewBackground

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun SheetTextField(
    modifier: Modifier = Modifier,
    value: String,
    isError: Boolean = false,
    errorText: String = "",
    singleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    Column(modifier then Modifier.fillMaxWidth()) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
            placeholder = placeholder,
            isError = isError,
            singleLine = singleLine,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions
        )
        if (isError && errorText.isNotEmpty()) {
            Text(
                text = errorText, fontSize = 14.sp, color = Color.Red,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}

@Preview
@Composable
fun SheetTextFieldPreview() {
    TodoListPreviewBackground {
        SheetTextField(
            modifier = Modifier.padding(20.dp),
            value = "Test",
            onValueChange = {

            },
            isError = true,
            errorText = "This user name already exists"
        )
    }
}