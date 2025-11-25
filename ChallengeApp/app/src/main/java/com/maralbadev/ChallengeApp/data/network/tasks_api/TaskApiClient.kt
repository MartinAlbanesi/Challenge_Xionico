package com.maralbadev.ChallengeApp.data.network.tasks_api

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.maralbadev.ChallengeApp.data.network.tasks_api.models.ErrorMessage
import com.maralbadev.ChallengeApp.data.network.tasks_api.models.TaskApiModel
import retrofit2.Response

class TaskApiClient(private val taskService: ITaskApiService) : ITaskClient {

    // Obtiene la respuesta de la API y devuelve una lista de tareas, o una excepción en caso de error
    override suspend fun fetchTasks(): List<TaskApiModel> {
        try {
            val response = taskService.getTasks()
            if (response.isSuccessful) {
                return response.body() ?: emptyList()
            } else {
                // --- SAFE ERROR PARSING START ---
                val errorString = response.errorBody()?.string()
                try {
                    // Try to parse JSON
                    val errorObj = Gson().fromJson(errorString, ErrorMessage::class.java)
                    throw Exception(errorObj.statusMessage)
                } catch (e: Exception) {
                    // Fallback if JSON parsing fails (e.g., it was HTML or empty)
                    throw Exception("Server Error: ${response.code()} - $errorString")
                }
                // --- SAFE ERROR PARSING END ---
            }
        } catch (e: Exception) {
            throw Exception("Error fetching tasks: ${e.message}")
        }
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