package com.maralbadev.ChallengeApp.data.network.tasks_api

import com.maralbadev.ChallengeApp.data.network.tasks_api.models.TaskApiModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ITaskApiService {
    @GET ("/tasks")
    suspend fun getTasks(): Response<List<TaskApiModel>>

    @POST("/add")
    suspend fun postTask(@Body task: TaskApiModel): Response<TaskApiModel>
}