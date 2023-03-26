package com.bagadesh.baseui.components

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Created by bagadesh on 25/03/23.
 */

object ClearRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor (): Color = Color.Transparent

    @Composable
    override fun rippleAlpha () = RippleAlpha (
        draggedAlpha = 0.0f,
        focusedAlpha = 0.0f,
        hoveredAlpha = 0.0f,
        pressedAlpha = 0.0f,
    )
}