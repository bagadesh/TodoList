package com.baga.data.repository

import com.baga.data.db.AppDatabase
import com.baga.data.db.entity.ProjectData
import com.baga.data.mapper.toProjectData
import com.baga.data.mapper.toProjectDomain
import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.result.project.GetAllProjectResult
import com.baga.domain.result.project.GetProjectTypesResult
import com.baga.domain.result.project.ProjectAddResult
import com.baga.domain.usecase.project.AddProjectUseCaseRequest
import com.baga.domain.usecase.project.GetAllProjectUseCaseRequest
import com.baga.domain.usecase.project.GetProjectTypesUseCaseRequest
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
class ProjectRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : ProjectRepository {

    override suspend fun addProject(request: AddProjectUseCaseRequest): Data<ProjectAddResult> {
        val projectData = ProjectData(
            title = request.title,
            projectType = request.projectType,
            dueDate = request.dueDate
        )
        appDatabase.projectDao().insertAll(projectData)
        return Data.Success(ProjectAddResult(Unit)) //TODO
    }

    override suspend fun getAllProjects(request: GetAllProjectUseCaseRequest): Data<GetAllProjectResult> {
        return Data.Success(
            GetAllProjectResult(
                result = appDatabase.projectDao().getAll().map { it.toProjectDomain() }
            )
        )
    }

    override suspend fun getProjectTypes(request: GetProjectTypesUseCaseRequest): Data<GetProjectTypesResult> {
        return Data.Success(
            data = GetProjectTypesResult(
                list = appDatabase.projectTypeDao().getAllProjectTypes().map { it.projectType }
            )
        )
    }
}