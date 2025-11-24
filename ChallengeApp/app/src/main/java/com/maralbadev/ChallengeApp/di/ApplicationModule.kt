package com.maralbadev.ChallengeApp.di
import com.maralbadev.ChallengeApp.data.network.tasks_api.ITaskApiService
import com.maralbadev.ChallengeApp.ui.viewmodels.MainActivityViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8000")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ITaskApiService::class.java)
    }
}

val appModule = module {
    viewModelOf(::MainActivityViewModel)
}