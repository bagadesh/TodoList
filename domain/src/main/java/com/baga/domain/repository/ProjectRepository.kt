package com.baga.domain.repository

import com.baga.domain.result.Data
import com.baga.domain.result.project.GetAllProjectResult
import com.baga.domain.result.project.ProjectAddResult
import com.baga.domain.usecase.project.AddProjectUseCaseRequest
import com.baga.domain.usecase.project.GetAllProjectUseCaseRequest

/**
 * Created by bagadesh on 04/03/23.
 */
interface ProjectRepository {

    suspend fun addProject(request: AddProjectUseCaseRequest): Data<ProjectAddResult>

    suspend fun getAllProjects(request: GetAllProjectUseCaseRequest): Data<GetAllProjectResult>

}