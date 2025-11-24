package com.maralbadev.ChallengeApp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maralbadev.ChallengeApp.domain.use_cases.CreateTaskUseCase
import com.maralbadev.ChallengeApp.domain.use_cases.GetTasksUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(getTasksUseCase: GetTasksUseCase, createTaskUseCase: CreateTaskUseCase) : ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO){
            val tasks = getTasksUseCase()

            tasks.forEach { task ->
                Log.d("MainActivityViewModel", "Task: $task")
            }
        }
    }
}