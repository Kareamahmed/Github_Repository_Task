package com.example.githubreposapp.data.dataSources.remote

import com.example.githubreposapp.data.dataSources.remote.api.DetailsApiService
import com.example.githubreposapp.data.dataSources.remote.api.IssuesApiService
import com.example.githubreposapp.data.dataSources.remote.api.ReposApiService
import com.example.githubreposapp.data.dataSources.remote.model.details.DetailsDataModel
import com.example.githubreposapp.data.dataSources.remote.model.issues.IssuesDataModel
import com.example.githubreposapp.data.dataSources.remote.model.repos.GithubReposDataModel
import com.example.githubreposapp.data.mapper.toCustomExceptionDomainModel
import javax.inject.Inject

class GithubRepsRemoteDataSource @Inject constructor(
    private val githubReposeApi: ReposApiService,
    private val detailsApi: DetailsApiService,
    private val issuesApi:IssuesApiService
) {

    suspend fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubReposeApi.fitchGithubRepos().body() as GithubReposDataModel
        } catch (e: Exception) {
            throw e.toCustomExceptionDomainModel()
        }
    }

    suspend fun fetchGithubDetails(owner: String, name: String): DetailsDataModel {
        return try {
            detailsApi.fetchGithubDetails(owner, name).body() as DetailsDataModel
        } catch (e: Exception) {
            throw e.toCustomExceptionDomainModel()
        }
    }
    suspend fun fetchReposIssues(owner: String, name: String): IssuesDataModel {
        return try {
            issuesApi.fetchGithubIssues(owner, name).body() as IssuesDataModel
        } catch (e: Exception) {
            throw e.toCustomExceptionDomainModel()
        }
    }
}