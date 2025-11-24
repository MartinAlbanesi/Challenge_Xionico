package com.maralbadev.ChallengeApp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maralbadev.ChallengeApp.domain.models.TaskModel
import com.maralbadev.ChallengeApp.ui.theme.ChallengeAppTheme
import okhttp3.Challenge

// Componente de la lista de tareas
@Composable
fun TodoList(tasks: List<TaskModel> = emptyList(),modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
    ) {
        LazyColumn(
            content = {
                itemsIndexed(tasks) { index: Int, item: TaskModel ->
                    TodoListItem(
                        item = item,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    )
                }
            }
        )
    }
}

// Previews

@Preview
@Composable
private fun TodoListPreview_light() {
    ChallengeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            TodoList(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun TodoListPreview_dark() {
    ChallengeAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            TodoList(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
            )
        }
    }
}