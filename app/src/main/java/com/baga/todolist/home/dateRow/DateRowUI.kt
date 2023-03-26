package com.baga.todolist.home.dateRow

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.baga.domain.OurDate
import com.bagadesh.baseui.components.ClearRippleTheme

@Composable
fun DateRowUI(
    dateResult: LazyPagingItems<OurDate>
) {
    var selectedIndex: Int by remember {
        mutableStateOf(0)
    }
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(dateResult) { index, value ->
            value?.also {
                DateRowItemUI(index, value, selectedIndex) { i, ourDate ->
                    selectedIndex = i
                }
            }
        }
    }
}

@Composable
fun DateRowItemUI(
    index: Int,
    date: OurDate,
    selectedIndex: Int,
    onClick: (Int, OurDate) -> Unit
) {
    val textColor: Color
    val backgroundColor: Color

    if (selectedIndex == index) {
        textColor = Color.White
        backgroundColor = MaterialTheme.colors.primary

    } else {
        textColor = MaterialTheme.colors.onSurface
        backgroundColor = MaterialTheme.colors.surface
    }
    CompositionLocalProvider (
        LocalRippleTheme provides ClearRippleTheme
    ) {
        // All views inside this will have no ripple
        DateTopBackground(
            backgroundColor = backgroundColor,
            onClick = {
                onClick(index,date)
            }
        ) {
            Text(
                text = date.day.toString(),
                color = textColor,
            )
            Text(
                text = date.dateEEE,
                color = textColor,
                fontSize = 11.sp
            )
        }
    }

}