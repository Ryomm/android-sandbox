package com.example.hiltandmultimodule.di

import com.example.hiltandmultimodule.data.remote.QiitaAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideJsonConverter(): Json {
        return Json { ignoreUnknownKeys = true }
    }

    @Singleton
    @Provides
    fun provideNewsApi(client: OkHttpClient, converter: Json): QiitaAPI {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl("https://qiita.com")
            .addConverterFactory(converter.asConverterFactory(contentType))
            .client(client)
            .build()
            .create(QiitaAPI::class.java)
    }
}