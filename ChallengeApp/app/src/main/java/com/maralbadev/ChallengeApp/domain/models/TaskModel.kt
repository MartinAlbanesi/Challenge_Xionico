package com.maralbadev.ChallengeApp.domain.models

data class TaskModel(
    val id: String,
    val title: String,
    val description: String?,
    var isCompleted: Boolean
)