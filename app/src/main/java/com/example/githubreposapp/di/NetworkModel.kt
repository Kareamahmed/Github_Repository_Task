package com.example.githubreposapp.di

import com.example.githubreposapp.data.Constants.Companion.BASE_URL
import com.example.githubreposapp.data.dataSources.remote.api.DetailsApiService
import com.example.githubreposapp.data.dataSources.remote.api.IssuesApiService
import com.example.githubreposapp.data.dataSources.remote.api.ReposApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModel {
    @Provides
    @Singleton
    fun getRetrofitInstant(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getReposApiService(
        retrofit: Retrofit
    ): ReposApiService {
        return retrofit.create(ReposApiService::class.java)
    }

    @Provides
    @Singleton
    fun getDetailsApiService(
        retrofit: Retrofit
    ): DetailsApiService {
        return retrofit.create(DetailsApiService::class.java)
    }

    @Provides
    @Singleton
    fun getIssuesApiService(
        retrofit: Retrofit
    ): IssuesApiService {
        return retrofit.create(IssuesApiService::class.java)
    }

}

