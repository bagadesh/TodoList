package com.bagadesh.baseui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by bagadesh on 05/03/23.
 */

@Composable
fun SheetSaveButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier then Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colors.surface,
            backgroundColor = MaterialTheme.colors.surface
        )
    ) {
        Text(text = text, color = MaterialTheme.colors.onPrimary)
    }
}