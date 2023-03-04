package com.baga.domain.usecase.project

import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.result.project.GetAllProjectResult
import com.baga.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
class GetAllProjectUseCase @Inject constructor(
    private val projectRepository: dagger.Lazy<ProjectRepository>
) : BaseUseCase<GetAllProjectUseCaseRequest, GetAllProjectResult>() {

    override suspend fun executeOnBackground(param: GetAllProjectUseCaseRequest): Data<GetAllProjectResult> {
        return projectRepository.get().getAllProjects(request = param)
    }
}

data class GetAllProjectUseCaseRequest(
    val unit: Unit = Unit
)