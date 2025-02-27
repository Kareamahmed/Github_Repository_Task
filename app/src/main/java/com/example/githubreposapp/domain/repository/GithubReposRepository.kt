package com.example.githubreposapp.domain.repository

import com.example.githubreposapp.data.dataSources.remote.model.issues.IssuesDataModel
import com.example.githubreposapp.domain.model.GithubDetailsDomainModel
import com.example.githubreposapp.domain.model.GithubIssuesDomainModel
import com.example.githubreposapp.domain.model.GithubRepoDomainModel

interface GithubReposRepository {
   suspend fun fetchGithubRepos():List<GithubRepoDomainModel>

   suspend fun fetchDetailsRepos(owner:String,name:String):GithubDetailsDomainModel

   suspend fun fetchIssuesRepos(owner:String,name:String):List<GithubIssuesDomainModel>
}