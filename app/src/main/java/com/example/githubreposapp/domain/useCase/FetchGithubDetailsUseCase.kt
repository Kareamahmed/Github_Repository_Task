package com.example.githubreposapp.domain.useCase

import com.example.githubreposapp.domain.model.GithubDetailsDomainModel
import com.example.githubreposapp.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubDetailsUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {
    suspend operator fun invoke(owner: String, name: String): GithubDetailsDomainModel {
        return githubReposRepository.fetchDetailsRepos(owner, name)
    }
}