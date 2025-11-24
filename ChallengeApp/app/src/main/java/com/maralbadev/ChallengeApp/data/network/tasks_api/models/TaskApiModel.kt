package com.maralbadev.ChallengeApp.data.network.tasks_api.models

import com.google.gson.annotations.SerializedName

data class TaskApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val title: Int,
    @SerializedName("todo") val description: String?,
    @SerializedName("completed") var isCompleted: Boolean
)