package com.example.githubreposapp.di

import com.example.githubreposapp.data.repository.GithubReposRepositoryImpl
import com.example.githubreposapp.domain.repository.GithubReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideRepositoryModuleImpl(
        githubReposRepositoryImpl: GithubReposRepositoryImpl
    ): GithubReposRepository
}