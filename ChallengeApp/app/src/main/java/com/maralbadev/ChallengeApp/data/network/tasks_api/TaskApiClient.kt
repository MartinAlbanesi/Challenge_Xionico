package com.maralbadev.ChallengeApp.data.network.tasks_api

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.maralbadev.ChallengeApp.data.network.tasks_api.models.ErrorMessage
import com.maralbadev.ChallengeApp.data.network.tasks_api.models.TaskApiModel
import retrofit2.Response

class TaskApiClient(private val taskService: ITaskApiService) : ITaskClient {

    // Obtiene la respuesta de la API y devuelve una lista de tareas, o una excepción en caso de error
    override suspend fun fetchTasks(): List<TaskApiModel> {
        val response = taskService.getTasks()
        if(!response.isSuccessful) {
            throw Exception(handleUnsuccessfulResponse(response).statusMessage)
        }

        return response.body() ?: emptyList()
    }

    // Crea una tarea en la API y devuelve la respuesta, o una excepción en caso de error
    override suspend fun createTask(task: TaskApiModel): TaskApiModel {
        val response = taskService.postTask(task)

        if (!response.isSuccessful) {
            throw Exception(handleUnsuccessfulResponse(response).statusMessage)
        }
        return response.body() ?: throw Exception("Server created task but returned empty body")
    }

    // Maneja la respuesta de la API en caso de error y devuelve un mensaje
    private fun <T> handleUnsuccessfulResponse(response: Response<T>): ErrorMessage {
        return try {
            val errorBodyString = response.errorBody()?.string() ?: return ErrorMessage(response.code(), "Unknown Error")
            Gson().fromJson(errorBodyString, ErrorMessage::class.java)
        } catch (e: JsonSyntaxException) {
            ErrorMessage(response.code(), "Error parsing error message")
        } catch (e: Exception) {
            ErrorMessage(500, "Unknown exception")
        }
    }
}