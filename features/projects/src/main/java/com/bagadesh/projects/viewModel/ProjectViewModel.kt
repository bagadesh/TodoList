package com.bagadesh.projects.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baga.domain.result.project.GetAllProjectResult
import com.baga.domain.result.project.ProjectAddResult
import com.baga.domain.usecase.project.AddProjectUseCase
import com.baga.domain.usecase.project.AddProjectUseCaseRequest
import com.baga.domain.usecase.project.DeleteProjectUseCase
import com.baga.domain.usecase.project.DeleteProjectUseCaseRequest
import com.baga.domain.usecase.project.GetAllProjectUseCase
import com.baga.domain.usecase.project.GetAllProjectUseCaseRequest
import com.bagadesh.baseui.uiState.UIState
import com.bagadesh.baseui.uiState.emitUseCase
import com.bagadesh.baseui.uiState.ifSuccess
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
    private val deleteProjectUseCase: dagger.Lazy<DeleteProjectUseCase>,
) : ViewModel() {

    var projectName = mutableStateOf("")
    var selectedProjectType = mutableStateOf("")
    var dueDate = mutableStateOf("")

    var addProjectState = MutableStateFlow<UIState<ProjectAddResult>>(UIState.Loading())
        private set
    var allProjectsState = MutableStateFlow<UIState<GetAllProjectResult>>(UIState.Loading())
        private set

    var selectedProjects = MutableStateFlow<List<Int>>(emptyList())

    init {
        viewModelScope.launch {
            fetchAllProjects()
        }
    }

    private suspend fun fetchAllProjects() {
        allProjectsState.emitUseCase(
            useCase = getAllProjectUseCase.get(), param = GetAllProjectUseCaseRequest()
        )
    }

    fun clickProjectItem(projectId: Int) {
        if (selectedProjects.value.isNotEmpty()) {
            longClickProjectItem(projectId = projectId)
        } else {
            //Do something else
        }
    }

    fun longClickProjectItem(projectId: Int) {
        val result = selectedProjects.value.toMutableList()
        if (selectedProjects.value.contains(projectId)) {
            result.remove(projectId)
        } else {
            result.add(projectId)
        }
        selectedProjects.tryEmit(result)
    }

    fun selectAllProjects() {
        selectedProjects.tryEmit(allProjectsState.value.ifSuccess(map = { result.map { it.id } }, default = emptyList()))
    }

    fun closeButtonClick() {
        //De Select all items
        selectedProjects.tryEmit(emptyList())
    }

    fun deleteProject(projectId: Int) {
        deleteGivenProjects(list = listOf(projectId))
    }

    fun deleteSelectedProjects() {
        deleteGivenProjects(list = selectedProjects.value.toList())
    }

    private fun deleteGivenProjects(list: List<Int>) {
        viewModelScope.launch {
            deleteProjectUseCase.get().execute(param = DeleteProjectUseCaseRequest(projectIds = list))
            selectedProjects.emit(emptyList())
            fetchAllProjects()
        }
    }

    fun addProject(
        title: String, projectType: String, dueDate: String
    ) {
        viewModelScope.launch {
            addProjectState.emitUseCase(
                useCase = addProjectUseCase.get(), param = AddProjectUseCaseRequest(
                    title = title, projectType = projectType, dueDate = dueDate
                )
            )
            fetchAllProjects()
            //clearFields()
        }
    }

    fun clearFields() {
        projectName.value = ""
        selectedProjectType.value = ""
        dueDate.value = ""
    }

}