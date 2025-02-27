package com.example.githubreposapp.ui.screens.repos_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.repos_screen.model.GithubRepoUiModel

@Composable
fun RepoItem(
    modifier: Modifier = Modifier,
    repoItemData: GithubRepoUiModel,
    onItemClick:(owner:String, name :String)->Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onItemClick(repoItemData.owner,repoItemData.name) },

        ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(repoItemData.avatar)
                    .crossfade(1000)
                    .build()

            ),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(7.dp)
                .padding(top = 5.dp)
                .clip(CircleShape)
        )
        Column(Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = repoItemData.name,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = repoItemData.stars.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Image(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .size(30.dp)
                )

            }
            Text(
                text = repoItemData.owner,
                style =MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.padding(5.dp))
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                text = repoItemData.description,
                maxLines = 2,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

//@Preview
//@Composable
//private fun Repo() {
//    GithubReposAppTheme {
//        RepoItem(
//            repoItemData = RepoItemData(1, "repo name ", "owner", 4646, R.drawable.ic_issues, "des des des des desdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdesdes "),
//            onRepoItemClicked = {}
//        )
//    }
//
//}