package com.baga.domain.usecase.base

import com.baga.domain.result.Data
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

/**
 * Created by bagadesh on 04/03/23.
 */
abstract class BaseUseCase<Param, Result> {

    suspend fun execute(param: Param): Data<Result> {
        return coroutineScope {
            try {
                withContext(Dispatchers.IO) {
                    executeOnBackground(param)
                }
            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exception: Exception) {
                Data.Failure<Result>(exception = exception)
            }
        }
    }

    protected abstract suspend fun executeOnBackground(param: Param): Data<Result>

}