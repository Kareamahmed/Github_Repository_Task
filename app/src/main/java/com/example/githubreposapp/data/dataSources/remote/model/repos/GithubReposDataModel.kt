package com.example.githubreposapp.data.dataSources.remote.model.repos

data class GithubReposDataModel(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)