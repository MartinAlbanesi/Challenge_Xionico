package com.maralbadev.ChallengeApp.data.network.tasks_api.models

import com.google.gson.annotations.SerializedName

data class TaskApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: Int,
    @SerializedName("description") val description: String?,
    @SerializedName("is_completed") var isCompleted: Boolean
)