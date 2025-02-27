package com.example.githubreposapp.ui.mapper

import com.example.githubreposapp.domain.model.GithubIssuesDomainModel
import com.example.githubreposapp.ui.screens.issue_screen.model.ReposIssuesUiModel

fun GithubIssuesDomainModel.toGithubIssuesUiModel(): ReposIssuesUiModel {
    return ReposIssuesUiModel(
        id = this.id,
        title = this.title,
        date = this.date,
        state = this.state,
        author = this.author
    )
}