package com.example.githubreposapp.ui.screens.issue_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.commonComponents.RepoAppBar
import com.example.githubreposapp.ui.screens.commonComponents.error_screen.ErrorScreen
import com.example.githubreposapp.ui.screens.commonComponents.shimmer_screen.issues.ShimmerIssues
import com.example.githubreposapp.ui.screens.issue_screen.viewModel.RepoIssuesViewModel
import com.example.githubreposapp.ui.theme.light_background

@Composable
fun IssueScreen(
    owner: String,
    name: String,
    onClickBackArrow: () -> Unit
) {
    val vm: RepoIssuesViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        vm.requestReposIssues(owner, name)
    }
    val issues by vm.issuesStateFlow.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(light_background),
    ) {
        RepoAppBar(
            title = R.string.title_issue,
            showBackArrow = true,
            onClickIconArrow = { onClickBackArrow() })
        when {
            issues.isLoading -> {
                ShimmerIssues()
            }

            issues.isError -> {
                ErrorScreen(
                    customErrorException = issues.customExceptionUiModel
                ) {
                    vm.requestReposIssues(owner, name)
                }
            }

            else -> {
                LazyColumn {
                    items(issues.issuesUiModel) { issue ->
                        IssueItem(
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                                .padding(horizontal = 12.dp), issueData = issue
                        )
                    }
                }
            }
        }
    }
}