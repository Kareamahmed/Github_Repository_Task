package com.example.githubreposapp.domain.model

data class GithubIssuesDomainModel(
    val id: Long,
    val title:String,
    val author:String,
    val state:String,
    val date:String
)
