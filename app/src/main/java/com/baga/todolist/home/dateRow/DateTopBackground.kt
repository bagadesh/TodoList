package com.baga.todolist.home.dateRow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by bagadesh on 25/03/23.
 */

@Composable
fun DateTopBackground(
    backgroundColor: Color = MaterialTheme.colors.surface,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val modifier = Modifier
        .padding(5.dp)
        .clip(RoundedCornerShape(10.dp))
        .size(60.dp, 80.dp)
        .background(backgroundColor)
        .clickable { onClick() }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        content()
    }
}