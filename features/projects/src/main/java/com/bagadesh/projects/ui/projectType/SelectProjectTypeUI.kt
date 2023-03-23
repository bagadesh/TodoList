package com.bagadesh.projects.ui.projectType

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by bagadesh on 21/03/23.
 */

@Composable
fun SelectProjectTypeUI(
    modifier: Modifier = Modifier,
    selectedProjectType: String,
    list: List<String>,
    onClick: (String) -> Unit,
    backClick: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = backClick, modifier = Modifier.padding(10.dp)) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back", modifier = Modifier.weight(0.2f))
        }
        Text(
            text = "Select Project Type",
            modifier = Modifier.weight(0.8f),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
    LazyColumn(
        modifier = modifier then Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(items = list) { projectType ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClick(projectType)
                    }
                    .padding(10.dp)
            ) {
                if (selectedProjectType == projectType) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Check", modifier = Modifier
                        .padding(start = 15.dp)
                        .align(Alignment.CenterStart))
                }
                Text(
                    text = projectType,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    color = MaterialTheme.colors.primary,
                    textAlign = TextAlign.Center
                )

            }

        }
    }
}