package com.bagadesh.baseui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun SheetTitle(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        color = MaterialTheme.colors.onPrimary,
        fontSize = 20.sp,
        modifier = modifier,
        fontWeight = FontWeight.Bold
    )
}