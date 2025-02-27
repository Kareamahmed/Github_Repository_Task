package com.example.githubreposapp.domain.useCase

import com.example.githubreposapp.domain.model.GithubRepoDomainModel
import com.example.githubreposapp.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubReposUseCase @Inject constructor(
    private val githubReposRepository : GithubReposRepository
) {
    suspend operator fun invoke():List<GithubRepoDomainModel>{
        return githubReposRepository.fetchGithubRepos()
    }
}