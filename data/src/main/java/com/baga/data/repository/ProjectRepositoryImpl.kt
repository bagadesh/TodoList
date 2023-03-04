package com.baga.data.repository

import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.usecase.project.AddProjectUseCaseRequest
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
class ProjectRepositoryImpl @Inject constructor(): ProjectRepository {

    override fun addProject(request: AddProjectUseCaseRequest): Data<Unit> {
        TODO("Not yet implemented")
    }
}