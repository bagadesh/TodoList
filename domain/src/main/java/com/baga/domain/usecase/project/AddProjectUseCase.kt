package com.baga.domain.usecase.project

import com.baga.domain.entity.ProjectDomain
import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
class AddProjectUseCase @Inject constructor(
    private val projectRepository: dagger.Lazy<ProjectRepository>
): BaseUseCase<AddProjectUseCaseRequest, Unit>() {

    override suspend fun executeOnBackground(param: AddProjectUseCaseRequest): Data<Unit> {
        return projectRepository.get().addProject(param)
    }
}

data class AddProjectUseCaseRequest(
    val project: ProjectDomain
)