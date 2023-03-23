package com.baga.domain.usecase.project

import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * Created by bagadesh on 21/03/23.
 */
class AddProjectTypeUseCase @Inject constructor(
    private val projectRepository: dagger.Lazy<ProjectRepository>
): BaseUseCase<AddProjectTypeUseCaseRequest, Unit>() {

    override suspend fun executeOnBackground(param: AddProjectTypeUseCaseRequest): Data<Unit> {
        return projectRepository.get().addProjectType(request = param)
    }
}

data class AddProjectTypeUseCaseRequest(
    val projectType: String
)