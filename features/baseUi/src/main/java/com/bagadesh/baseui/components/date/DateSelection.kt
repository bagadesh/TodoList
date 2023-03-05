@file:OptIn(ExperimentalLayoutApi::class, ExperimentalLayoutApi::class)

package com.bagadesh.baseui.components.date

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bagadesh.baseui.theme.TodoListTheme
import com.squaredem.composecalendar.ComposeCalendar
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar
import java.util.Date

/**
 * Created by bagadesh on 04/03/23.
 */

const val DefaultDate = "Today"

@Composable
fun DateSelection(
    modifier: Modifier = Modifier,
    update: (String) -> Unit
) {
    var dueDate by remember { mutableStateOf(todayInMills()) }
    var selectedDate by remember { mutableStateOf(DefaultDate) }
    val showDialog = rememberSaveable { mutableStateOf(false) }
    val list = remember { listOf("Today", "Tomorrow", "Another Date") }
    val startDate by remember {
        derivedStateOf {
            if (dueDate.isNotEmpty()) {
                Instant.ofEpochMilli(dueDate.toLong())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
            } else {
                LocalDate.now()
            }
        }
    }
    FlowRow(
        modifier = modifier then Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        list.forEach {
            DateDisplayView(
                title = it,
                selected = it == selectedDate,
            ) {
                selectedDate = it
                when (it) {
                    "Another Date" -> {
                        showDialog.value = true
                    }

                    else -> {
                        val calendar = Calendar.getInstance().apply {
                            if (it == "Tomorrow") {
                                add(Calendar.DATE, 1);
                            }
                            set(Calendar.HOUR_OF_DAY, 0);
                            set(Calendar.MINUTE, 0);
                            set(Calendar.SECOND, 0);
                        }
                        dueDate = calendar.timeInMillis.toString()
                        update(dueDate)
                    }
                }
            }
        }
        if (dueDate.isNotEmpty()) {
            DateBackground(
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Text(
                    text = remember {
                        derivedStateOf {
                            dueDate.toDateString()
                        }
                    }.value,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 5.dp),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }

    // then show the dialog based on the state
    if (showDialog.value) {
        ComposeCalendar(
            startDate = startDate,
            onDone = { it: LocalDate ->
                // Hide dialog
                showDialog.value = false
                // Do something with the date
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);

                calendar.set(Calendar.YEAR, it.year)
                calendar.set(Calendar.MONTH, it.monthValue - 1)
                calendar.set(Calendar.DAY_OF_MONTH, it.dayOfMonth)

                dueDate = calendar.timeInMillis.toString()
                update(dueDate)
            },
            onDismiss = {
                // Hide dialog
                showDialog.value = false
                if (dueDate.isEmpty()) {
                    val calendar = Calendar.getInstance()
                    calendar.set(Calendar.HOUR_OF_DAY, 0);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    dueDate = calendar.timeInMillis.toString()
                    update(dueDate)
                }
            }
        )
    }
}

private fun todayInMills(): String {
    val calendar = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0);
        set(Calendar.MINUTE, 0);
        set(Calendar.SECOND, 0);
    }
    return calendar.timeInMillis.toString()
}

fun String.toDateString(): String {
    val timeInMillis = toLong() // some time value in milliseconds
    val formatter = SimpleDateFormat("dd/MM/yyyy") // create a formatter with the desired pattern
    return formatter.format(Date(timeInMillis))
}

@Preview
@Composable
fun DateSelectionPreview() {
    TodoListTheme {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center
        ) {
            DateSelection(
                modifier = Modifier,
                update = {

                }
            )
        }
    }
}