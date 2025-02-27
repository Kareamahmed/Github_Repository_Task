package com.example.githubreposapp.data.dataSources.remote.api

import com.example.githubreposapp.data.Constants.Companion.NAME_KEY
import com.example.githubreposapp.data.Constants.Companion.OWNER_KEY
import com.example.githubreposapp.data.dataSources.remote.model.details.DetailsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApiService {
    @GET("repos/{$OWNER_KEY}/{$NAME_KEY}")
    suspend fun fetchGithubDetails(
        @Path(OWNER_KEY) owner: String,
        @Path(NAME_KEY) name: String
    ): Response<DetailsDataModel>
}