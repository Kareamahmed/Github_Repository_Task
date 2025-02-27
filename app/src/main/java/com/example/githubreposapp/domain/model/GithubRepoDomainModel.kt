package com.example.githubreposapp.domain.model

data class GithubRepoDomainModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val owner: String,
    val stars: Int
)
