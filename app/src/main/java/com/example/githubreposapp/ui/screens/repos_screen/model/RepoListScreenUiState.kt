package com.example.githubreposapp.ui.screens.repos_screen.model

import com.example.githubreposapp.ui.model.CustomExceptionUiModel

data class RepoListScreenUiState(
    val isLoading: Boolean = false,
    val isError:Boolean=false,
    val githubRepoListUiModel:List<GithubRepoUiModel> = emptyList(),
    val customExceptionUiModel:CustomExceptionUiModel =CustomExceptionUiModel.UnKnown
)