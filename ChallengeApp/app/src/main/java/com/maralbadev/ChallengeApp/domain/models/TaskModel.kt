package com.maralbadev.ChallengeApp.domain.models

data class TaskModel(
    val id: Int,
    val title: String,
    val description: String?,
    var isCompleted: Boolean
)