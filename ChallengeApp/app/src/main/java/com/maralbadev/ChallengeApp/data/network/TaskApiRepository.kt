package com.maralbadev.ChallengeApp.data.network

import com.maralbadev.ChallengeApp.data.network.tasks_api.ITaskClient
import com.maralbadev.ChallengeApp.domain.interfaces.ITaskRepository
import com.maralbadev.ChallengeApp.domain.mappers.toTask
import com.maralbadev.ChallengeApp.domain.mappers.toTaskApi
import com.maralbadev.ChallengeApp.domain.models.TaskModel

class TaskApiRepository (private val taskClient: ITaskClient) : ITaskRepository {

    override suspend fun getTasks(): List<TaskModel> {
        return taskClient.fetchTasks().map { it.toTask() }
    }

    override suspend fun postTask(task: TaskModel): TaskModel {
        return taskClient.createTask(task.toTaskApi()).toTask()
    }
}