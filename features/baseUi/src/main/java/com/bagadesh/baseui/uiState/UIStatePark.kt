package com.bagadesh.baseui.uiState

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

/**
 * Created by bagadesh on 04/03/23.
 */


@Composable
fun <T> UIStatePark(
    modifier: Modifier = Modifier,
    state: UIState<T>,
    loading: @Composable (() -> Unit)? = null,
    failure: @Composable ((Throwable) -> Unit)? = null,
    success: @Composable ColumnScope.(T) -> Unit,
) {
    Column(modifier = modifier then Modifier) {
        when (state) {
            is UIState.Loading -> {
                loading?.invoke()
            }
            is UIState.Failure -> {
                Log.d( "UIStatePark","UIStatePark ${state.throwable.message}", state.throwable)
                if (failure != null) {
                    failure.invoke(state.throwable)
                } else {
                    Text(text = "Something went wrong")
//                    if (BuildConfig.DEBUG) {
                        Text(
                            text = "Error: ${state.throwable.stackTraceToString()}",
                            fontSize = 12.sp
                        )
//                    }
                }
            }
            is UIState.Success -> {
                success(state.data)
            }
        }
    }
}

@Composable
fun <T> UIStatePark(
    modifier: Modifier = Modifier,
    state: () -> UIState<T>,
    loading: @Composable (() -> Unit)? = null,
    failure: @Composable ((Throwable) -> Unit)? = null,
    success: @Composable ColumnScope.(T) -> Unit,
) {
    Column(modifier = modifier then Modifier) {
        when (val stateResult = state()) {
            is UIState.Loading -> {
                loading?.invoke()
            }
            is UIState.Failure -> {
                Log.d( "UIStatePark","UIStatePark ${stateResult.throwable.message}", stateResult.throwable)
                if (failure != null) {
                    failure.invoke(stateResult.throwable)
                } else {
                    Text(text = "Something went wrong")
//                    if (BuildConfig.DEBUG) {
                    Text(
                        text = "Error: ${stateResult.throwable.stackTraceToString()}",
                        fontSize = 12.sp
                    )
//                    }
                }
            }
            is UIState.Success -> {
                success(stateResult.data)
            }
        }
    }
}