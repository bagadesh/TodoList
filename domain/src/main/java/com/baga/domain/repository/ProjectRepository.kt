package com.baga.domain.repository

import com.baga.domain.result.Data
import com.baga.domain.usecase.project.AddProjectUseCaseRequest

/**
 * Created by bagadesh on 04/03/23.
 */
interface ProjectRepository {

    fun addProject(request: AddProjectUseCaseRequest): Data<Unit>

}