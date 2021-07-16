package com.baga.todolist.home.projects

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baga.domain.Project
import com.baga.todolist.R
import com.baga.todolist.home.common.TitleWithCount

@Composable
fun ProjectHome() {
    val result = listOf<Project>(
        Project(
            "Wedding",
            "16 Jun 2020",
            16
        ), Project(
            "Birthday",
            "19 Jun 2020",
            19
        ),   Project(
            "Wedding",
            "16 Jun 2020",
            16
        ), Project(
            "Birthday",
            "19 Jun 2020",
            19
        )
    )
    Column(
        modifier = Modifier
            .padding(start = 10.dp, top = 30.dp)
            .fillMaxWidth()

    ) {
        TitleWithCount(title = "Projects", count = result.count())
        LazyRow(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(result) {
                ProjectIt(it)
            }
        }
    }
}

@Composable
fun ProjectIt(
    project: Project
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(start = 10.dp,end = 10.dp)
            .size(150.dp)
            .background(MaterialTheme.colors.onSurface)
            .padding(10.dp)

    ) {
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