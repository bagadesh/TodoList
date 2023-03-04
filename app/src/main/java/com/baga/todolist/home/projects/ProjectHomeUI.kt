package com.baga.todolist.home.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baga.domain.Project
import com.baga.todolist.home.common.TitleWithCount
import com.baga.todolist.ui.theme.TodoListTheme


@Composable
fun ProjectHomeUI(
    projectList: List<Project>
) {
    val sizeOfProjectList = remember { projectList.size }
    Column(
        modifier = Modifier
            .padding(start = 10.dp, top = 30.dp)
            .fillMaxWidth()

    ) {
        ProjectHeadingUI(
            modifier = Modifier,
            count = sizeOfProjectList,
            addClick = {

            }
        )
        if (sizeOfProjectList == 0) {
            EmptyProjectHomeUI(
                modifier = Modifier
                    .padding(top = 20.dp)
            )
        } else {
            LazyRow(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items(projectList) {
                    ProjectItemUI(it)
                }
            }
        }
    }
}


@Preview
@Composable
fun ProjectHomeUIPreview() {
    val result: List<Project> by lazy {
        listOf(
            Project(
                "Wedding",
                "16 Jun 2020",
                16
            ), Project(
                "Birthday",
                "19 Jun 2020",
                19
            ), Project(
                "Wedding",
                "16 Jun 2020",
                16
            ), Project(
                "Birthday",
                "19 Jun 2020",
                19
            )
        )
    }
    TodoListTheme {
        ProjectHomeUI(result)
    }
}

@Preview
@Composable
fun EmptyProjectHomeUIPreview() {
    ProjectHomeUI(emptyList())
}