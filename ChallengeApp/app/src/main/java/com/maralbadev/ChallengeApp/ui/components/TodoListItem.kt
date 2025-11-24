package com.maralbadev.ChallengeApp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maralbadev.ChallengeApp.domain.models.TaskModel
import com.maralbadev.ChallengeApp.ui.theme.ChallengeAppTheme

// Componente de un elemento de la lista de tareas
@Composable
fun TodoListItem(item: TaskModel, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        // Botón para marcar la tarea como completada o incompleta
        OutlinedButton(
            onClick = {
                item.isCompleted = !item.isCompleted
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Icon(
                imageVector = if (item.isCompleted) Icons.Filled.Check else Icons.Filled.Info, // Access standard icons
                contentDescription = "Icon buttom list"
            )
        }

        // Contenido de la tarea
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
            item.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoListItemPreview_light() {
    ChallengeAppTheme {
        Surface(
            modifier = Modifier.wrapContentSize()
        ) {
            TodoListItem(
                item = TaskModel(
                    id = 1,
                    title = "Title",
                    description = "Description",
                    isCompleted = false,
                )
            )
        }
    }
}

@Preview
@Composable
private fun TodoListItemPreview_dark() {
    ChallengeAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.wrapContentSize()
        ) {
            TodoListItem(
                item = TaskModel(
                    id = 1,
                    title = "Title",
                    description = "Description",
                    isCompleted = false,
                )
            )
        }
    }
}