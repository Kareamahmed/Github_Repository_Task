package com.example.githubreposapp.data.dataSources.remote.api

import com.example.githubreposapp.data.Constants.Companion.NAME_KEY
import com.example.githubreposapp.data.Constants.Companion.OWNER_KEY
import com.example.githubreposapp.data.dataSources.remote.model.issues.IssuesDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IssuesApiService {
    @GET("repos/{$OWNER_KEY}/{$NAME_KEY}/issues")
    suspend fun fetchGithubIssues(
        @Path(OWNER_KEY) owner: String,
        @Path(NAME_KEY) name: String
    ):Response<IssuesDataModel>
}