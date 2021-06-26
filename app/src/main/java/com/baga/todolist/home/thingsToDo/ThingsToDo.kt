package com.baga.todolist.home.thingsToDo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baga.domain.entity.thingsTodo.Todo
import com.baga.todolist.home.common.TitleWithCount
import com.baga.todolist.testing.CheckboxImpl
import com.baga.todolist.ui.theme.CardBackground

@Composable
fun ThingsTodo(
    data: List<Todo>,
    onClickBoxClick: (Todo) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(start = 10.dp, top = 30.dp)
    ) {
        item {
            TitleWithCount(
                title = "Things to do",
                count = data.size,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
        items(data) {
            ThinkView(it, onClickBoxClick)
        }
    }
}

@Composable
fun ThinkView(
    todo: Todo,
    onClickBoxClick: (Todo) -> Unit,
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
                onClickBoxClick(todo)
            })
        Column(
            modifier = Modifier.padding(start = 20.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
        ) {
            Text(
                text = todo.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(CardBackground)
                    .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Date Image",
                    tint = MaterialTheme.colors.primary
                )
                Text(
                    text = todo.whenHappening,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
    }
}