package com.baga.domain.usecase.project

import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.result.project.ProjectAddResult
import com.baga.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
class AddProjectUseCase @Inject constructor(
    private val projectRepository: dagger.Lazy<ProjectRepository>
): BaseUseCase<AddProjectUseCaseRequest, ProjectAddResult>() {

    override suspend fun executeOnBackground(param: AddProjectUseCaseRequest): Data<ProjectAddResult> {
        return projectRepository.get().addProject(param)
    }
}

data class AddProjectUseCaseRequest(
    val title: String,
    val projectType: String,
    val dueDate: String
)