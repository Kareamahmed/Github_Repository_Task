package com.example.githubreposapp.domain.useCase

import com.example.githubreposapp.domain.model.GithubIssuesDomainModel
import com.example.githubreposapp.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchReposIssuesUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {
    suspend operator fun invoke(owner: String, name: String): List<GithubIssuesDomainModel> {
        return githubReposRepository.fetchIssuesRepos(owner, name)
    }
}
