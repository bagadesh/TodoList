package com.baga.data.repository

import com.baga.data.db.AppDatabase
import com.baga.data.mapper.toProjectData
import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.usecase.project.AddProjectUseCaseRequest
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
class ProjectRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
): ProjectRepository {

    override suspend fun addProject(request: AddProjectUseCaseRequest): Data<Unit> {
        val projectData = request.project.toProjectData()
        appDatabase.projectDao().insertAll(projectData)
        return Data.Success(Unit)
    }
}