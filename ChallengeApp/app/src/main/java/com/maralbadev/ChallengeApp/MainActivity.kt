package com.maralbadev.ChallengeApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maralbadev.ChallengeApp.ui.components.TodoList
import com.maralbadev.ChallengeApp.ui.theme.ChallengeAppTheme
import com.maralbadev.ChallengeApp.ui.viewmodels.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            ChallengeAppTheme {
                val tasksState = viewModel.tasks.collectAsState(initial = emptyList())

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoList(
                        tasks = tasksState.value,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainActivityPreview_light() {
    ChallengeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
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
private fun MainActivityPreview_dark() {
    ChallengeAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TodoList(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
            )
        }
    }
}