package com.bagadesh.baseui.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun DateDisplayView(
    title: String
) {
    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(MaterialTheme.colors.surface)
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.DateRange,
            contentDescription = "Date Image",
            tint = MaterialTheme.colors.onPrimary
        )
        Text(
            text = title,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 5.dp),
            color = MaterialTheme.colors.onPrimary
        )
    }
}