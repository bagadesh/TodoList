package com.bagadesh.projects.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bagadesh.projects.R

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun ProjectItemUI(
    title: String,
    projectType: String,
    dueDate: String,
    upcomingCount: Int,
    iconResource: Int
) {
    ProjectSurfaceUI {
        Image(
            painter = painterResource(id = iconResource),
            contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .size(24.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        Text(
            text = projectType,
            fontSize = 16.sp,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Due on ${dueDate}",
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = "$upcomingCount Upcoming",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Preview
@Composable
fun ProjectItemUIPreview() {
    ProjectItemUI(
        title = "Test Title",
        projectType = "Birthday",
        dueDate = "2130712837891",
        upcomingCount = 19,
        iconResource = R.drawable.ic_ring
    )
}