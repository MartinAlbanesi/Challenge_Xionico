package com.maralbadev.ChallengeApp.domain.use_cases

import com.maralbadev.ChallengeApp.domain.interfaces.ITaskRepository
import com.maralbadev.ChallengeApp.domain.models.TaskModel

class GetTasksUseCase(private val repository: ITaskRepository) {
    suspend operator fun invoke(): List<TaskModel> {
        return repository.getTasks()
    }
}