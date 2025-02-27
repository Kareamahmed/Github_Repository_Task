package com.example.githubreposapp.ui.screens.commonComponents

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoAppBar(
    @StringRes title: Int,
    onClickIconArrow: () -> Unit = {},
    showBackArrow: Boolean = true,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            if (showBackArrow) {
                IconButton(onClick = { onClickIconArrow() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Arrow Back"
                    )
                }
            }
        }
    )
    HorizontalDivider()

}

//@Preview
//@Composable
//private fun Test() {
//    RepoAppBar(
//        title = R.string.title_issue
//    )
//}
