package com.example.githubreposapp.ui.screens.detail_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubreposapp.domain.model.CustomExceptionDomainModel
import com.example.githubreposapp.domain.useCase.FetchGithubDetailsUseCase
import com.example.githubreposapp.ui.mapper.toCustomExceptionUiModel
import com.example.githubreposapp.ui.mapper.toGithubDetailsUiModel
import com.example.githubreposapp.ui.screens.detail_screen.model.GithubDetailScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubDetailsViewModel @Inject constructor(
    private val fetchGithubDetailsUseCase: FetchGithubDetailsUseCase
) : ViewModel() {

    private var _detailsStateFlow:MutableStateFlow<GithubDetailScreenUiState> = MutableStateFlow(
        GithubDetailScreenUiState()
    )

    val detailsStateFlow = _detailsStateFlow.asStateFlow()

    fun requestGithubDetails(owner: String, name: String) {
        _detailsStateFlow.value = GithubDetailScreenUiState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val githubDetailsDomainModel = fetchGithubDetailsUseCase(owner, name)
                _detailsStateFlow.value = GithubDetailScreenUiState(
                    githubDetailsUiModel = githubDetailsDomainModel.toGithubDetailsUiModel()
                )
            } catch (e: Exception){
                _detailsStateFlow.value =GithubDetailScreenUiState(
                    isError = true,
                    customExceptionUiModel = (e as CustomExceptionDomainModel).toCustomExceptionUiModel()
                )
            }
        }
    }
}