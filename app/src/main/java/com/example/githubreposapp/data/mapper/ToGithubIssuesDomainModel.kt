package com.example.githubreposapp.data.mapper

import com.example.githubreposapp.data.dataSources.remote.model.issues.IssuesDataModel
import com.example.githubreposapp.data.dataSources.remote.model.issues.IssuesDataModelItem
import com.example.githubreposapp.domain.model.GithubIssuesDomainModel

fun IssuesDataModel.toIssuesDomainModel():List<GithubIssuesDomainModel>{
    return this.map { GithubIssuesDomainModel(
        id = it.id,
        title = it.title,
        author = it.author_association,
        state = it.state,
        date = formatDate(it.created_at)
    ) }
}