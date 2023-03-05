package com.bagadesh.projects.ui.addProject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val getProjectTypesUseCase: dagger.Lazy<GetProjectTypesUseCase>
) : ViewModel() {

    var allProjectTypes = MutableStateFlow<UIState<List<String>>>(UIState.Loading())
        private set

    init {
        viewModelScope.launch {
            allProjectTypes.emit(
                value = getProjectTypesUseCase.get().toUIResult(GetProjectTypesUseCaseRequest())
                    .mapUISuccess { it.list }
            )
        }
    }

}