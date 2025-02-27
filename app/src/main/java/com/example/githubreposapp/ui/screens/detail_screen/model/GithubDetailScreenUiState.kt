package com.example.githubreposapp.ui.screens.detail_screen.model

import com.example.githubreposapp.ui.model.CustomExceptionUiModel

data class GithubDetailScreenUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val githubDetailsUiModel: GithubDetailsUiModel? = null,
    val customExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.UnKnown
)