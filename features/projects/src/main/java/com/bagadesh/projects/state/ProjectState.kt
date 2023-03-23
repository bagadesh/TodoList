package com.bagadesh.projects.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.bagadesh.projects.route.ProjectRoutes

/**
 * Created by bagadesh on 10/03/23.
 */
data class ProjectState(
    private val addProjectTypeToDB: (String) -> Unit,
    private val navController: NavHostController
) {

    fun addProjectType(projectType: String) {
        this.addProjectTypeToDB(projectType)
    }

    fun openSelectProjectTypes() {
        navController.navigate(route = ProjectRoutes.selectProjectTypeRoute)
    }

    fun backPress() {
        navController.popBackStack()
    }
}

@Composable
fun rememberProjectState(
    addProjectTypeToDB: (String) -> Unit,
    navController: NavHostController
): ProjectState {
    return remember(addProjectTypeToDB, navController) {
        ProjectState(
            addProjectTypeToDB = addProjectTypeToDB,
            navController = navController
        )
    }
}