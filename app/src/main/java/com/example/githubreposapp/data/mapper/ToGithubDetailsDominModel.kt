package com.example.githubreposapp.data.mapper

import com.example.githubreposapp.data.dataSources.remote.model.details.DetailsDataModel
import com.example.githubreposapp.domain.model.GithubDetailsDomainModel

fun DetailsDataModel.toGithubDetailsDomainModel():GithubDetailsDomainModel{
    return GithubDetailsDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.owner.avatar_url,
        description = this.description,
        stars = this.stargazersCount,
        owner = this.owner.login,
        forks = this.forks,
        language = this.language ?: "",
        fullName = this.fullName,
        url = this.url,
        createdAt = this.createdAt
    )
}