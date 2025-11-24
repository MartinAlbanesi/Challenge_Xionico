package com.maralbadev.ChallengeApp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maralbadev.ChallengeApp.domain.models.TaskModel
import com.maralbadev.ChallengeApp.domain.CreateTaskUseCase
import com.maralbadev.ChallengeApp.domain.GetTasksUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getTasksUseCase: GetTasksUseCase,
    //private val createTaskUseCase: CreateTaskUseCase
) : ViewModel() {

    init {
        getTasks()
    }

    private val _tasks = MutableStateFlow<List<TaskModel>>(emptyList())
    val tasks: StateFlow<List<TaskModel>> = _tasks.asStateFlow()

    private fun getTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val tasks = getTasksUseCase.invoke()
                _tasks.value = tasks
                Log.d("MainActivityViewModel", "Tasks: $tasks")
            } catch (e: Exception) {
                Log.e("MainActivityViewModel", "Error fetching tasks", e)
            }
        }
    }
}