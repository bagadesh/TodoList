package com.bagadesh.projects.ui

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
import com.baga.domain.entity.ProjectDomain
import com.bagadesh.projects.R


@Composable
fun ProjectHomeUI(
    projectList: List<ProjectDomain>,
    selectedProjectItems: () -> List<Int>,
    addProjectClick: () -> Unit,
    onClick: (Int) -> Unit,
    onLongClick: (Int) -> Unit,
) {
    val sizeOfProjectList = remember(projectList) { projectList.size }
    Column(
        modifier = Modifier
            .padding(start = 10.dp, top = 30.dp)
            .fillMaxWidth()

    ) {
        ProjectHeadingUI(
            modifier = Modifier,
            count = sizeOfProjectList,
            addClick = addProjectClick
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
                horizontalArrangement = Arrangement.Start
            ) {
                items(projectList) {
                    ProjectItemUI(
                        title = it.title,
                        projectType = it.projectType,
                        dueDate = it.dueDate,
                        iconResource = R.drawable.ic_ring, //TODO
                        upcomingCount = 19, //TODO
                        onClick = {
                            onClick(it.id)
                        },
                        onLongClick = {
                            onLongClick(it.id)
                        },
                        selected = selectedProjectItems().contains(it.id)
                    )
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
//    ProjectHomeUI(
//        result.map {
//            ProjectDomain(
//                id = 1,
//                title = "Sample title",
//                dueDate = "1237198238923",
//                projectType = it.title
//            )
//        }
//    ) {
//
//    }
}

@Preview
@Composable
fun EmptyProjectHomeUIPreview() {
//    ProjectHomeUI(emptyList()) {
//
//    }
}