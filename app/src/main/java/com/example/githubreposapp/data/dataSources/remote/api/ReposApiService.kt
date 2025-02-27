package com.example.githubreposapp.data.dataSources.remote.api

import com.example.githubreposapp.data.Constants.Companion.GITHUB_REPOS_ENDPOINT
import com.example.githubreposapp.data.dataSources.remote.model.repos.GithubReposDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ReposApiService {
    @GET(GITHUB_REPOS_ENDPOINT)
    suspend fun fitchGithubRepos(): Response<GithubReposDataModel>
}