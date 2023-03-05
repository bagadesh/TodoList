package com.bagadesh.tasks.ui

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircleItem(
    title: String,
    imageVector: ImageVector? = null
) {
    val endDp = if (imageVector != null) 5.dp else 0.dp
    Row(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colors.surface)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                contentDescription = "Date Image",
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier.padding(start = 5.dp,end = 5.dp)
            )
        }

        Text(
            text = title,
            fontSize = 14.sp,
            modifier = Modifier.padding(end = endDp),
            color = MaterialTheme.colors.onPrimary
        )
    }
}