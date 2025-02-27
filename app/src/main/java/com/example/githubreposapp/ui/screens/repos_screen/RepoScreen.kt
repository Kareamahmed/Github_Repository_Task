package com.example.githubreposapp.ui.screens.repos_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.commonComponents.RepoAppBar
import com.example.githubreposapp.ui.screens.commonComponents.error_screen.ErrorScreen
import com.example.githubreposapp.ui.screens.commonComponents.shimmer_screen.repos.ShimmerScreen
import com.example.githubreposapp.ui.screens.repos_screen.viewmodel.GithubReposViewModel
import com.example.githubreposapp.ui.theme.light_background
import kotlinx.coroutines.launch


@Composable
fun RepoScreen(onItemClick: (owner: String, name: String) -> Unit) {

    val vm: GithubReposViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        vm.requestGithubRepoList()
    }
    val repoListUiState by vm.repoListStateFlow.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray.copy(0.5f)),
    ) {
        RepoAppBar(title = R.string.app_name, showBackArrow = false)
        when {
            repoListUiState.isLoading -> {
                ShimmerScreen()
            }

            repoListUiState.isError -> {
                ErrorScreen(
                    customErrorException = repoListUiState.customExceptionUiModel,
                    onRetryButtonClick = {
                        scope.launch {
                            vm.requestGithubRepoList()
                        }
                    }
                )
            }

            else -> {
                LazyColumn {
                    items(repoListUiState.githubRepoListUiModel) { repo ->
                        RepoItem(
                            Modifier
                                .padding(vertical = 4.dp)
                                .padding(horizontal = 12.dp),
                            repo,
                            onItemClick =  onItemClick
                        )
                    }
                }
            }
        }
    }
}


//@Preview
//@Composable
//private fun Test() {
//
//}