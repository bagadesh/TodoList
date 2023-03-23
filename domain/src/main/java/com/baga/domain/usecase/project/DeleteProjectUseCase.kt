package com.baga.domain.usecase.project

import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * Created by bagadesh on 23/03/23.
 */
class DeleteProjectUseCase @Inject constructor(
    private val projectRepository: dagger.Lazy<ProjectRepository>
) : BaseUseCase<DeleteProjectUseCaseRequest, Unit>() {

    override suspend fun executeOnBackground(param: DeleteProjectUseCaseRequest): Data<Unit> {
        return projectRepository.get().deleteProject(request = param)
    }
}

data class DeleteProjectUseCaseRequest(
    val projectIds: List<Int>
)