package com.baga.domain.debug

/**
 * Created by bagadesh on 21/03/23.
 */
interface Logger {

    fun logDebug(text: String)

}

val debugLogger: Logger by lazy { LoggerImpl() }


