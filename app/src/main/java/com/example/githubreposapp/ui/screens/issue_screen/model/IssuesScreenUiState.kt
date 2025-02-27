package com.example.githubreposapp.ui.screens.issue_screen.model

import com.example.githubreposapp.ui.model.CustomExceptionUiModel

data class IssuesScreenUiState (
     val isLoading:Boolean = false,
     val isError:Boolean= false,
     val issuesUiModel: List<ReposIssuesUiModel> = emptyList(),
     val customExceptionUiModel: CustomExceptionUiModel =CustomExceptionUiModel.UnKnown
 )