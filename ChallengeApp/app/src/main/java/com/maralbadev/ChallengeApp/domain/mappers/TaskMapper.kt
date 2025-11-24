package com.maralbadev.ChallengeApp.domain.mappers

import com.maralbadev.ChallengeApp.data.network.tasks_api.models.TaskApiModel
import com.maralbadev.ChallengeApp.domain.models.TaskModel

fun TaskApiModel.toTask() : TaskModel {
    return TaskModel(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted
    )
}

fun TaskModel.toTaskApi() : TaskApiModel {
    return TaskApiModel(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted
    )
}