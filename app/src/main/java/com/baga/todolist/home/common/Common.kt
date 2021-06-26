package com.baga.todolist.home.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleWithCount(
    title: String,
    count: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 24.sp, fontWeight = FontWeight.Black,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Box(
            modifier = Modifier
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(50))
                .size(30.dp)
                .background(Color(0xFFF8FAFB)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$count",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}