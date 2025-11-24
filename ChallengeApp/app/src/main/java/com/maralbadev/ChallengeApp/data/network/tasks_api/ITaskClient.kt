package com.maralbadev.ChallengeApp.data.network.tasks_api

import com.maralbadev.ChallengeApp.data.network.tasks_api.models.TaskApiModel

interface ITaskClient {
    suspend fun fetchTasks(): List<TaskApiModel>
    suspend fun createTask(task: TaskApiModel): TaskApiModel
}