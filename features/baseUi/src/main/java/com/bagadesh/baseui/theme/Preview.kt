package com.bagadesh.baseui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Created by bagadesh on 05/03/23.
 */

@Composable
fun TodoListPreviewBackground(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
    backgroundColor: Color = MaterialTheme.colors.background,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    TodoListTheme(darkTheme = darkTheme) {
        Column(modifier = modifier then Modifier.background(backgroundColor)) {
            content()
        }
    }
}