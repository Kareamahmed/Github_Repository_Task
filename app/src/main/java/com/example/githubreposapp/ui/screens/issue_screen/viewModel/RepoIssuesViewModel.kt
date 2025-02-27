package com.example.githubreposapp.ui.screens.issue_screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubreposapp.domain.model.CustomExceptionDomainModel
import com.example.githubreposapp.domain.useCase.FetchReposIssuesUseCase
import com.example.githubreposapp.ui.mapper.toCustomExceptionUiModel
import com.example.githubreposapp.ui.mapper.toGithubIssuesUiModel
import com.example.githubreposapp.ui.screens.issue_screen.model.IssuesScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoIssuesViewModel @Inject constructor(
    private val fetchReposIssuesUseCase: FetchReposIssuesUseCase
) : ViewModel() {

    private var _issuesStateFlow: MutableStateFlow<IssuesScreenUiState> = MutableStateFlow(
        IssuesScreenUiState()
    )
    val issuesStateFlow = _issuesStateFlow.asStateFlow()

    fun requestReposIssues(owner: String, name: String){

        viewModelScope.launch (Dispatchers.IO){

            try {
                _issuesStateFlow.value = IssuesScreenUiState(
                    issuesUiModel = fetchReposIssuesUseCase(owner, name).map {
                        it.toGithubIssuesUiModel()
                    }
                )
            }catch (e:Exception){
                _issuesStateFlow.value= IssuesScreenUiState(
                    isError = true,
                    customExceptionUiModel = (e as CustomExceptionDomainModel ).toCustomExceptionUiModel()
                )
            }
        }

    }
}