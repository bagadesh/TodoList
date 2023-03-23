package com.bagadesh.projects.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by bagadesh on 04/03/23.
 */
@Preview
@Composable
fun EmptyProjectHomeUI(
    modifier: Modifier = Modifier
) {
    ProjectSurfaceUI(modifier = modifier, onClick = {}, onLongClick = {}, selected = false) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No upcoming projects",
                modifier = Modifier
            )
        }
    }
}