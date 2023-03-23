package com.bagadesh.projects.ui.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bagadesh.baseui.theme.TodoListPreviewBackground
import com.bagadesh.projects.R

/**
 * Created by bagadesh on 23/03/23.
 */

@Composable
fun ProjectSelectedBottomBar(
    modifier: Modifier = Modifier,
    deleteClick: () -> Unit,
    selectAllClick: () -> Unit,
    closeClick: () -> Unit,
) {

    val modifier = modifier then Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(100.dp)

    Card(
        backgroundColor = MaterialTheme.colors.onBackground,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    closeClick()
                },
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(50))
                    .wrapContentSize()
                    .padding(10.dp)
                    .background(color = MaterialTheme.colors.background, RoundedCornerShape(50))
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    imageVector = Icons.Filled.Close, contentDescription = "Close"
                )
            }
            
            IconButton(
                onClick = {
                    deleteClick()
                },
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(50))
                    .wrapContentSize()
                    .padding(10.dp)
                    .background(color = MaterialTheme.colors.background, RoundedCornerShape(50))
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    imageVector = Icons.Filled.Delete, contentDescription = "Delete"
                )
            }

            IconButton(
                onClick = {
                    selectAllClick()
                },
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(50))
                    .wrapContentSize()
                    .padding(10.dp)
                    .background(color = MaterialTheme.colors.background, RoundedCornerShape(50))
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.ic_select_all), contentDescription = "Select All"
                )
            }

        }
    }

}

@Preview
@Composable
fun ProjectSelectedBottomBarPreview() {
    TodoListPreviewBackground {
        ProjectSelectedBottomBar(
            modifier = Modifier,
            deleteClick = {},
            selectAllClick = {},
            closeClick = {},
        )
    }

}