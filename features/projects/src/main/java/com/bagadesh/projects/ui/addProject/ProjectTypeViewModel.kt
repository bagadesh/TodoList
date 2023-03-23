package com.bagadesh.projects.ui.addProject

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baga.domain.debug.printInLogger
import com.baga.domain.usecase.project.AddProjectTypeUseCase
import com.baga.domain.usecase.project.AddProjectTypeUseCaseRequest
import com.baga.domain.usecase.project.GetProjectTypesUseCase
import com.baga.domain.usecase.project.GetProjectTypesUseCaseRequest
import com.bagadesh.baseui.uiState.UIState
import com.bagadesh.baseui.uiState.mapUISuccess
import com.bagadesh.baseui.uiState.toUIResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by bagadesh on 05/03/23.
 */
@HiltViewModel
class ProjectTypeViewModel @Inject constructor(
    private val getProjectTypesUseCase: dagger.Lazy<GetProjectTypesUseCase>,
    private val addProjectTypeUseCase: dagger.Lazy<AddProjectTypeUseCase>,
) : ViewModel() {

    var allProjectTypes = MutableStateFlow<UIState<List<String>>>(UIState.Loading())
        private set

    init {
        viewModelScope.launch {
            fetchAllProjectTypes()
        }
    }

    private suspend fun fetchAllProjectTypes() {
        allProjectTypes.emit(
            value = getProjectTypesUseCase.get().toUIResult(GetProjectTypesUseCaseRequest())
                .mapUISuccess {
                    it.list.also {
                        printInLogger("ProjectTypeViewModel -> fetchAllProjectTypes -> count = ${it.size}")
                    }
                }
        )
    }

    fun doneAction(text: String) {
        printInLogger("ProjectTypeViewModel -> doneAction -> $text")
        if (allProjectTypes.value !is UIState.Success) {
            return
        }
        val doesItAlreadyExists = (allProjectTypes.value as UIState.Success).data.any { it.contentEquals(text, true) }
        if (doesItAlreadyExists) {
            // Use it
            printInLogger("ProjectTypeViewModel -> doneAction -> Already Exists")
        } else {
            // Create a new Project Type
            viewModelScope.launch {
                printInLogger("ProjectTypeViewModel -> doneAction -> Adding Project Type")
                addProjectTypeUseCase.get().execute(param = AddProjectTypeUseCaseRequest(projectType = text)) // Add to the database using use case
                fetchAllProjectTypes()
            }

        }
    }

}