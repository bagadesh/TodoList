package com.baga.todolist.home.projects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun ProjectHeadingUI(
    modifier: Modifier,
    count: Int,
    addClick: () -> Unit
) {
    Row(
        modifier = modifier then Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Projects",
            fontSize = 24.sp, fontWeight = FontWeight.Normal,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        ProjectHeadingItemBackground(modifier = Modifier.padding(start = 10.dp)) {
            Text(
                text = "$count",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp)
            )
        }
        ProjectHeadingItemBackground(modifier = Modifier.padding(start = 10.dp)) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add"
                )
                Text(
                    text = "add",
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(0.dp)
                )
            }
        }
    }
}

@Composable
fun ProjectHeadingItemBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier then Modifier
            .clip(RoundedCornerShape(50))
            .wrapContentWidth()
            .widthIn(min = 30.dp)
            .heightIn(min = 30.dp)
            .background(color = MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview
@Composable
fun ProjectHeadingUIPreview() {
    ProjectHeadingUI(
        modifier = Modifier,
        count = 0
    ) {

    }
}