package com.bagadesh.baseui.components.date

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun DateDisplayView(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val textColor: Color
    val backgroundColor: Color
    when (selected) {
        false -> {
            textColor = MaterialTheme.colors.onPrimary
            backgroundColor = MaterialTheme.colors.surface
        }

        true -> {
            textColor = MaterialTheme.colors.surface
            backgroundColor = MaterialTheme.colors.onPrimary
        }
    }
    DateBackground(
        backgroundColor = backgroundColor,
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Outlined.DateRange,
            contentDescription = "Date Image",
            tint = textColor
        )
        Text(
            text = title,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 5.dp),
            color = textColor
        )
    }
}

@Composable
fun DateBackground(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    enabledButton: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier then Modifier
            .padding(start = 10.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(backgroundColor)
            .clickable(enabled = enabledButton) {
                onClick()
            }
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}