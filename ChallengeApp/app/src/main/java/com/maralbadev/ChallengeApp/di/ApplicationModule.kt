package com.maralbadev.ChallengeApp.di

import com.maralbadev.ChallengeApp.data.network.TaskApiRepository
import com.maralbadev.ChallengeApp.data.network.tasks_api.ITaskApiService
import com.maralbadev.ChallengeApp.data.network.tasks_api.ITaskClient
import com.maralbadev.ChallengeApp.data.network.tasks_api.TaskApiClient
import com.maralbadev.ChallengeApp.domain.CreateTaskUseCase
import com.maralbadev.ChallengeApp.domain.GetTasksUseCase
import com.maralbadev.ChallengeApp.domain.interfaces.ITaskRepository
import com.maralbadev.ChallengeApp.ui.viewmodels.MainActivityViewModel
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://127.0.0.1:8000")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ITaskApiService::class.java)
    }
}

val appModule = module {
    singleOf(::TaskApiClient) {
        bind<ITaskClient>()
    }

    singleOf(::TaskApiRepository) {
        bind<ITaskRepository>()
    }

    singleOf(::GetTasksUseCase)
    singleOf(::CreateTaskUseCase)


    viewModelOf(::MainActivityViewModel)
}