package com.example.githubreposapp.ui.screens.repos_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubreposapp.domain.model.CustomExceptionDomainModel
import com.example.githubreposapp.domain.useCase.FetchGithubReposUseCase
import com.example.githubreposapp.ui.mapper.toGithubRepoUiModel
import com.example.githubreposapp.ui.mapper.toCustomExceptionUiModel
import com.example.githubreposapp.ui.screens.repos_screen.model.RepoListScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubReposViewModel @Inject constructor(
    private val fetchGithubReposUseCase: FetchGithubReposUseCase
) : ViewModel() {

    private var _repoListStateFlow: MutableStateFlow<RepoListScreenUiState> = MutableStateFlow(
        RepoListScreenUiState()
    )
    val repoListStateFlow = _repoListStateFlow.asStateFlow()

    fun requestGithubRepoList() {
        _repoListStateFlow.value = RepoListScreenUiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val githubRepoDomainModel = fetchGithubReposUseCase()
                _repoListStateFlow.value = RepoListScreenUiState(
                    githubRepoListUiModel = githubRepoDomainModel.map { it.toGithubRepoUiModel() }
                )
            } catch (e: Exception) {
                _repoListStateFlow.value = RepoListScreenUiState(
                    isError = true,
                    customExceptionUiModel = (e as CustomExceptionDomainModel).toCustomExceptionUiModel()
                )
            }
        }


    }
}