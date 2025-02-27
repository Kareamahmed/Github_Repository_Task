package com.example.githubreposapp.data.mapper

import com.example.githubreposapp.data.dataSources.remote.model.repos.GithubReposDataModel
import com.example.githubreposapp.domain.model.GithubRepoDomainModel

fun GithubReposDataModel.toGithubRepoDomainModel(): List<GithubRepoDomainModel>{
    return this.items.map {item ->  GithubRepoDomainModel(
        id = item.id,
        name = item.name,
        avatar = item.owner.avatar_url,
        description = item.description,
        stars = item.stargazers_count,
        owner = item.owner.login
    )
    }
}