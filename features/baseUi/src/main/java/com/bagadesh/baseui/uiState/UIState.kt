package com.bagadesh.baseui.uiState

/**
 * Created by bagadesh on 04/03/23.
 */

sealed class UIState<T> {

    data class Loading<T> (var isLoading: Boolean = true) : UIState<T>()

    data class Success<T>(val data: T) : UIState<T>()

    data class Failure<T>(val throwable: Throwable) : UIState<T>()

}
