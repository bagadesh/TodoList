package com.bagadesh.baseui.uiState

import com.baga.domain.result.Data
import com.baga.domain.result.UIResultBlock
import com.baga.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * Created by bagadesh on 04/03/23.
 */

suspend fun <T> Flow<UIState<T>>.collectUIState(action: suspend UIResultBlock<T>.() -> Unit) {
    val response = UIResultBlock<T>().apply {
        action()
    }
    collect {
        when (it) {
            is UIState.Failure -> {
                response(it.throwable)
            }
            is UIState.Loading -> {
                response(true)
            }
            is UIState.Success -> {
                response(it.data)
            }
        }
    }
}


fun <Param, Result> BaseUseCase<Param, Result>.toFlow(
    param: Param
): Flow<UIState<Result>> = flow {
    emit(toUIResult(param))
}

fun <T, R> Flow<UIState<T>>.mapUIState(transform: suspend (T) -> R): Flow<UIState<R>> {
    return map {
        when (it) {
            is UIState.Loading -> UIState.Loading()
            is UIState.Failure -> UIState.Failure(it.throwable)
            is UIState.Success -> {
                UIState.Success(
                    transform(it.data)
                )
            }
        }
    }
}

inline fun <reified T, R> UIState<T>.mapUISuccess(transform: (T) -> R): UIState<R> {
    return when (this) {
        is UIState.Loading -> UIState.Loading()
        is UIState.Failure -> UIState.Failure(this.throwable)
        is UIState.Success -> {
            UIState.Success(
                transform(this.data)
            )
        }
    }
}

suspend fun <Param, Result> BaseUseCase<Param, Result>.toUIResult(param: Param): UIState<Result> {
    return when (val result = execute(param)) {
        is Data.Failure -> {
            com.bagadesh.baseui.uiState.UIState.Failure(result.exception)
        }
        is Data.Success -> {
            com.bagadesh.baseui.uiState.UIState.Success(result.data)
        }
    }
}

suspend fun <T, Param> MutableStateFlow<UIState<T>>.emitUseCase(
    useCase: BaseUseCase<Param, T>,
    param: Param
) {
    emit(
        value = useCase.toUIResult(param = param)
    )
}



