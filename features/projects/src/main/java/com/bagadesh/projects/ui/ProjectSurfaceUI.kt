package com.bagadesh.projects.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bagadesh.baseui.theme.projectItemSelectColor

/**
 * Created by bagadesh on 04/03/23.
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectSurfaceUI(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    selected: Boolean,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier then Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(start = 10.dp, end = 10.dp)
            .size(150.dp)
            .background(
                color = if (selected) projectItemSelectColor else MaterialTheme.colors.surface
            )
            .clickable(onClick = onClick)
            .combinedClickable(
                onClick = onClick,
                onLongClick = onLongClick
            )
            .padding(10.dp),
    ) {
        content()
    }
}