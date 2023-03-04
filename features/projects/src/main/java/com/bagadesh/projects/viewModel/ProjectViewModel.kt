package com.bagadesh.projects.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baga.domain.result.project.GetAllProjectResult
import com.baga.domain.result.project.ProjectAddResult
import com.baga.domain.usecase.project.AddProjectUseCase
import com.baga.domain.usecase.project.AddProjectUseCaseRequest
import com.baga.domain.usecase.project.GetAllProjectUseCase
import com.baga.domain.usecase.project.GetAllProjectUseCaseRequest
import com.bagadesh.baseui.uiState.UIState
import com.bagadesh.baseui.uiState.emitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by bagadesh on 04/03/23.
 */
@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val addProjectUseCase: dagger.Lazy<AddProjectUseCase>,
    private val getAllProjectUseCase: dagger.Lazy<GetAllProjectUseCase>,
) : ViewModel() {

    var addProjectState = MutableStateFlow<UIState<ProjectAddResult>>(UIState.Loading())
        private set
    var allProjectsState = MutableStateFlow<UIState<GetAllProjectResult>>(UIState.Loading())
        private set

    init {
        viewModelScope.launch {
            allProjectsState.emitUseCase(
                useCase = getAllProjectUseCase.get(),
                param = GetAllProjectUseCaseRequest()
            )
        }
    }

    fun addProject(
        title: String,
        projectType: String,
        dueDate: String
    ) {
        viewModelScope.launch {
            addProjectState.emitUseCase(
                useCase = addProjectUseCase.get(),
                param = AddProjectUseCaseRequest(
                    title = title,
                    projectType = projectType,
                    dueDate = dueDate
                )
            )
        }
    }

}