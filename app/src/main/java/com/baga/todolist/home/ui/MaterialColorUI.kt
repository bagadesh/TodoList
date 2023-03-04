package com.baga.todolist.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun MaterialColorUI() {
    val listOfColors = listOf(
        "primary" to MaterialTheme.colors.primary,
        "onPrimary" to MaterialTheme.colors.onPrimary,
        "background" to MaterialTheme.colors.background,
        "onBackground" to MaterialTheme.colors.onBackground,
        "secondary" to MaterialTheme.colors.secondary,
        "onSecondary" to MaterialTheme.colors.onSecondary,
        "surface" to MaterialTheme.colors.surface,
        "onSurface" to MaterialTheme.colors.onSurface,
        "primaryVariant" to MaterialTheme.colors.primaryVariant,
        "secondaryVariant" to MaterialTheme.colors.secondaryVariant,
        "onError" to MaterialTheme.colors.onError,
        "error" to MaterialTheme.colors.error,
    )
    LazyRow {
        items(listOfColors) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .background(it.second)
                    .border(1.dp, Color.White)
                    .padding(15.dp)
            ) {
                ColorText(it)
            }
        }
    }
}

val textColors = listOf(Color.White, Color.Black)

@Composable
fun ColorText(currentPair: Pair<String, Color>) {
    Text(
        text = currentPair.first,
        fontSize = 12.sp,
        color = if (textColors.first() == currentPair.second) {
            textColors.last()
        } else {
            textColors.first()
        }
    )
}