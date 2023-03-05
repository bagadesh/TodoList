package com.baga.domain.usecase.project

import com.baga.domain.repository.ProjectRepository
import com.baga.domain.result.Data
import com.baga.domain.result.project.GetProjectTypesResult
import com.baga.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * Created by bagadesh on 05/03/23.
 */
class GetProjectTypesUseCase @Inject constructor(
    private val projectRepository: dagger.Lazy<ProjectRepository>
) : BaseUseCase<GetProjectTypesUseCaseRequest, GetProjectTypesResult>() {

    override suspend fun executeOnBackground(param: GetProjectTypesUseCaseRequest): Data<GetProjectTypesResult> {
        return projectRepository.get().getProjectTypes(request = param)
    }
}

data class GetProjectTypesUseCaseRequest(val unit: Unit = Unit)