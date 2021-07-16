package com.baga.todolist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = CardBackgroundDark,
    primaryVariant = Purple700,
    secondary = Teal200,
    onSurface = CardBackgroundDark,
    onPrimary = Color.White,
    secondaryVariant = Color(0x88F8FAFB)
)

private val LightColorPalette = lightColors(
    primary = CardBackgroundLight,
    primaryVariant = Purple700,
    secondary = Teal200,
    onSurface = CardBackgroundLight,
    onPrimary = Color.Black,
    secondaryVariant = Color(0xFF000000)

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    */
)

@Composable
fun TodoListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content
    )
}