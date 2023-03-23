package com.baga.domain.debug

/**
 * Created by bagadesh on 21/03/23.
 */

inline fun printInLogger(text: String) {
    debugLogger.logDebug(text)
}
