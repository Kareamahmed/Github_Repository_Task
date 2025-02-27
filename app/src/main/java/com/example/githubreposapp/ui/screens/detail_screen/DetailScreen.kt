package com.example.githubreposapp.ui.screens.detail_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.commonComponents.RepoAppBar
import com.example.githubreposapp.ui.screens.commonComponents.error_screen.ErrorScreen
import com.example.githubreposapp.ui.screens.commonComponents.shimmer_screen.details.ShimmerDetailScreen
import com.example.githubreposapp.ui.screens.detail_screen.model.GithubDetailsUiModel
import com.example.githubreposapp.ui.screens.detail_screen.viewmodel.GithubDetailsViewModel
import com.example.githubreposapp.ui.theme.light_background

@Composable
fun DetailScreen(
    name: String,
    owner: String,
    onClickBackArrow: () -> Unit,
    onClickButton: () -> Unit
) {
    val vm: GithubDetailsViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        vm.requestGithubDetails(owner, name)
    }
    val detailsItemUiState by vm.detailsStateFlow.collectAsStateWithLifecycle()

    Column(Modifier.fillMaxSize()) {
        RepoAppBar(
            showBackArrow = true,
            title = R.string.title_details,
            onClickIconArrow = { onClickBackArrow() })
        when {
            detailsItemUiState.isLoading -> {
                ShimmerDetailScreen()
            }

            detailsItemUiState.isError -> {
                ErrorScreen(
                    customErrorException = detailsItemUiState.customExceptionUiModel
                ) {
                    vm.requestGithubDetails(owner, name)
                }
            }

            detailsItemUiState.githubDetailsUiModel != null -> {
                DetailsContact(
                    detailItem = detailsItemUiState.githubDetailsUiModel!!,
                    onClickButton = onClickButton
                )
            }
        }
    }
}

@Composable
fun DetailsContact(
    detailItem: GithubDetailsUiModel,
    onClickButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(light_background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .padding(top = 15.dp)
                .size(155.dp),

        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(detailItem.avatar)
                        .crossfade(1000)
                        .build()
                ),
                contentDescription = "GitHub Logo",
                modifier = Modifier
                    .size(155.dp)
                    .clip(CircleShape)
            )
        }


        Spacer(Modifier.size(15.dp))

        Text(
            modifier = Modifier.padding(horizontal = 15.dp),
            text = detailItem.name,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        )

        Spacer(Modifier.size(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ItemDetail(text = detailItem.stars.toString()) {
                Image(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = "Star Icon",
                    modifier = Modifier.size(35.dp)

                )
            }
            ItemDetail(text = detailItem.language) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .border(width = 0.5.dp, color = Color.Black, shape = CircleShape)
                        .padding(0.5.dp)
                        .background(Color.Red)
                )
            }
            ItemDetail(text = detailItem.forks.toString()) {
                Image(
                    painter = painterResource(R.drawable.ic_fork),
                    contentDescription = "Fork Icon",
                    Modifier.size(30.dp)
                )
            }
        }
        Spacer(Modifier.padding(top = 20.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(0.9f),
            text = detailItem.description,
            style = MaterialTheme.typography.headlineSmall,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.weight(1f))

        Button(
            onClick = { onClickButton() },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 50.dp)
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp)
        ) {
            Text(
                text = "Show Issue",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Composable
    fun ItemDetail(text: String, image: @Composable () -> Unit) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(7.dp)
            )
            image()
        }
    }

@Preview(showSystemUi = true, device = Devices.PIXEL_6)
@Composable
private fun TestDetail() {
    DetailScreen("", "", {}, {})
}