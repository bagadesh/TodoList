package com.bagadesh.tasks.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baga.domain.entity.thingsTodo.Todo
import com.bagadesh.baseui.components.DateDisplayView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThingsTodo(
    data: List<Todo>,
    onClickBoxClick: (Todo, Boolean) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(start = 10.dp, top = 30.dp)
    ) {
        stickyHeader {
            ThingsTodoHeading(
                title = "Things to do",
                count = data.size,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(bottom = 10.dp)
            )
        }
//        item {
//            TitleWithCount(
//                title = "Things to do",
//                count = data.size,
//                modifier = Modifier.padding(bottom = 10.dp)
//            )
//        }
        items(data) {
            ThinkView(it, onClickBoxClick)
        }
        item {
            Spacer(
                modifier = Modifier
                    .size(150.dp)
            )
        }

    }

}

@Composable
fun ThinkView(
    todo: Todo,
    onClickBoxClick: (Todo, Boolean) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
    ) {
        Checkbox(
            modifier = Modifier,
            checked = todo.isChecked, onCheckedChange = {
                onClickBoxClick(todo, it)
            })
        Column(
            modifier = Modifier.padding(start = 20.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
        ) {
            Text(
                text = todo.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            DateDisplayView(todo.whenHappening)
        }
    }
}