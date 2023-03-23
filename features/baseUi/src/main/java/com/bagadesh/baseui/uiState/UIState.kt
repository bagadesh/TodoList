package com.bagadesh.baseui.uiState

/**
 * Created by bagadesh on 04/03/23.
 */

sealed class UIState<T> {

    data class Loading<T>(var isLoading: Boolean = true) : UIState<T>()

    data class Success<T>(val data: T) : UIState<T>()

    data class Failure<T>(val throwable: Throwable) : UIState<T>()

}

fun <T, R> UIState<T>.ifSuccess(map: T.() -> R, default: R): R {
    return if (this is UIState.Success)
        map(data)
    else
        default
}

fun <T> UIState<List<T>>.toListOrEmpty(): List<T> {
    return if (this is UIState.Success)
        data
    else
        emptyList()
}
