package com.bagadesh.projects

import androidx.compose.foundation.background
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

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun ProjectSurfaceUI(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier then Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(start = 10.dp, end = 10.dp)
            .size(150.dp)
            .background(MaterialTheme.colors.surface)
            .padding(10.dp),
    ) {
        content()
    }
}