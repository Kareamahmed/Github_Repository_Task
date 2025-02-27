package com.example.githubreposapp.ui.mapper

import com.example.githubreposapp.domain.model.GithubDetailsDomainModel
import com.example.githubreposapp.ui.screens.detail_screen.model.GithubDetailsUiModel

fun GithubDetailsDomainModel.toGithubDetailsUiModel(): GithubDetailsUiModel {
    return GithubDetailsUiModel(
        id = this.id,
        name = this.name,
        owner = this.owner,
        avatar =this.avatar,
        description = this.description,
        forks= this.forks,
        language = this.language,
        stars =this.stars ,
        fullName = this.fullName,
    )
}