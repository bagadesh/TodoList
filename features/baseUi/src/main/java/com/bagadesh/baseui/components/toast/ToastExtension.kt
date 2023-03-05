package com.bagadesh.baseui.components.toast

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Created by bagadesh on 05/03/23.
 */

@Composable
fun Toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(
        LocalContext.current,
        message,
        length
    )
}