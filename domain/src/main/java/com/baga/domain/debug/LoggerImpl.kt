package com.baga.domain.debug

import com.baga.domain.debug.DebugConfigs.isDebugApplication

/**
 * Created by bagadesh on 21/03/23.
 */
class LoggerImpl: Logger {

    override fun logDebug(text: String) {
        if (isDebugApplication) {
            println(
                buildString {
                    append("datmug ")
                    append("Log: $text")
                }
            )
        }
    }
}