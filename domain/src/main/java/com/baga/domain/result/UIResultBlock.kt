package com.baga.domain.result

import kotlinx.coroutines.CancellationException

/**
 * Created by bagadesh on 04/03/23.
 */

open class UIResultBlock<T> {

    private var onLoading: (suspend (Boolean) -> Unit)? = null
    private var onSuccess: (suspend (T) -> Unit)? = null
    private var onErrorBlock: (suspend (Throwable) -> Unit)? = null
    private var onCancelBlock: (suspend (CancellationException) -> Unit)? = null
    private var onFinally: (suspend () -> Unit)? = null

    fun onSuccess(block: suspend (T) -> Unit) {
        onSuccess = block
    }

    fun onFinally(block: suspend () -> Unit) {
        onFinally = block
    }

    fun onError(block: suspend (Throwable) -> Unit) {
        onErrorBlock = block
    }

    fun onCancel(block: suspend (CancellationException) -> Unit) {
        onCancelBlock = block
    }

    fun onLoading(block: (suspend (Boolean) -> Unit)) {
        onLoading = block
    }

    open suspend operator fun invoke() {
        onFinally?.invoke()
    }

    open suspend operator fun invoke(result: T) {

        onSuccess?.invoke(result)
    }

    suspend operator fun invoke(status: Boolean) {
        onLoading?.invoke(status)
    }

    suspend operator fun invoke(error: Throwable) {
        onErrorBlock?.invoke(error)
    }

    suspend operator fun invoke(cancel: CancellationException) {
        onCancelBlock?.invoke(cancel)
    }
}
