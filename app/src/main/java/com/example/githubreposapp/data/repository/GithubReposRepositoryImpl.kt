package com.example.githubreposapp.data.repository

import com.example.githubreposapp.data.dataSources.remote.GithubRepsRemoteDataSource
import com.example.githubreposapp.data.mapper.toGithubDetailsDomainModel
import com.example.githubreposapp.data.mapper.toGithubRepoDomainModel
import com.example.githubreposapp.data.mapper.toIssuesDomainModel
import com.example.githubreposapp.domain.model.GithubDetailsDomainModel
import com.example.githubreposapp.domain.model.GithubIssuesDomainModel
import com.example.githubreposapp.domain.model.GithubRepoDomainModel
import com.example.githubreposapp.domain.repository.GithubReposRepository
import javax.inject.Inject

class GithubReposRepositoryImpl @Inject constructor(
    private val githubRepsRemoteDataSource : GithubRepsRemoteDataSource
):GithubReposRepository {
    override suspend fun fetchGithubRepos(): List<GithubRepoDomainModel> {
       return githubRepsRemoteDataSource.fetchGithubRepos().toGithubRepoDomainModel()
    }

    override suspend fun fetchDetailsRepos(owner:String , name :String): GithubDetailsDomainModel {
        return githubRepsRemoteDataSource.fetchGithubDetails(owner, name).toGithubDetailsDomainModel()
    }

    override suspend fun fetchIssuesRepos(owner: String, name: String):List<GithubIssuesDomainModel>{
        return githubRepsRemoteDataSource.fetchReposIssues(owner,name).toIssuesDomainModel()
    }
}