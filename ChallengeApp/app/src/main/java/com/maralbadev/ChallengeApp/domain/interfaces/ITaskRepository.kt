package com.maralbadev.ChallengeApp.domain.interfaces

import com.maralbadev.ChallengeApp.domain.models.TaskModel

interface ITaskRepository {
    suspend fun getTasks(): List<TaskModel>
    suspend fun postTask(task: TaskModel): TaskModel
}