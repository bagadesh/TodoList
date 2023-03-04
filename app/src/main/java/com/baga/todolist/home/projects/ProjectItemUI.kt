package com.baga.todolist.home.projects

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
import com.baga.domain.Project
import com.baga.todolist.R
import com.baga.todolist.ui.theme.TodoListTheme

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun ProjectItemUI(
    project: Project
) {
    ProjectSurfaceUI {
        Image(
            painter = painterResource(id = R.drawable.ic_ring),
            contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .size(24.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        Text(
            text = project.title,
            fontSize = 16.sp,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Due on ${project.dueDateString}",
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = "${project.count} Upcoming",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Preview
@Composable
fun ProjectItemUIPreview() {
    val project =  Project(
        "Birthday",
        "19 Jun 2020",
        19
    )
    TodoListTheme {
        ProjectItemUI(project = project)
    }
}