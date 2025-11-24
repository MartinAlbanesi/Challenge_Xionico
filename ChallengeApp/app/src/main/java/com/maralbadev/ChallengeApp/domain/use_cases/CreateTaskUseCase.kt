package com.maralbadev.ChallengeApp.domain.use_cases

import com.maralbadev.ChallengeApp.domain.interfaces.ITaskRepository
import com.maralbadev.ChallengeApp.domain.models.TaskModel

class CreateTaskUseCase(private val repository: ITaskRepository) {
    suspend operator fun invoke(task: TaskModel): TaskModel {
        return repository.postTask(task)
    }
}