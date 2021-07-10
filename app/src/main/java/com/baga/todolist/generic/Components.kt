package com.baga.todolist.generic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baga.todolist.ui.theme.CardBackground

@Composable
fun DateDisplayView(
    title: String
) {
    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(CardBackground)
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.DateRange,
            contentDescription = "Date Image",
            tint = MaterialTheme.colors.primary
        )
        Text(
            text = title,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}
@Preview
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
            .background(CardBackground)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                contentDescription = "Date Image",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 5.dp,end = 5.dp)
            )
        }

        Text(
            text = title,
            fontSize = 14.sp,
            modifier = Modifier.padding(end = endDp),
            color = MaterialTheme.colors.primary
        )
    }
}