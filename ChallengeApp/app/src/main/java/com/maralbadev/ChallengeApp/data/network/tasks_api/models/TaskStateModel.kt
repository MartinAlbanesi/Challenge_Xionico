package com.maralbadev.ChallengeApp.data.network.tasks_api.models

data class TaskStateModel (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val tasks: List<TaskApiModel> = emptyList()
)