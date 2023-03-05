@file:OptIn(ExperimentalLayoutApi::class, ExperimentalLayoutApi::class)

package com.bagadesh.baseui.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by bagadesh on 04/03/23.
 */

@Composable
fun DateSelection(
    modifier: Modifier = Modifier,
    ) {
    // Date Sections
    val list = listOf("Tomorrow", "Today", "Another Date")
    FlowRow(
        modifier = modifier then Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        list.forEach {
            DateDisplayView(title = it)
        }
    }
}