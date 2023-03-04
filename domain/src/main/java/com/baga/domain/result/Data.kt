package com.baga.domain.result

/**
 * Created by bagadesh on 04/03/23.
 */

sealed class Data<T> {

    data class Success<T>(val data: T) : Data<T>()

    data class Failure<T>(val exception: Exception) : Data<T>()

}
