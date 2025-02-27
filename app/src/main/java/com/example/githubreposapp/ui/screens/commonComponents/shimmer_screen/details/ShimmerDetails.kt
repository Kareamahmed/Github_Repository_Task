package com.example.githubreposapp.ui.screens.commonComponents.shimmer_screen.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubreposapp.ui.screens.commonComponents.shimmer_screen.repos.shimmerEffect

@Composable
fun ShimmerDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(top = 30.dp)
                .size(200.dp)
                .clip(CircleShape)
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(0.4f)
                .height(26.dp)
                .clip(RoundedCornerShape(8.dp))
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.padding(top = 25.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(
                count = 3
            ) {
                Box(
                    modifier = Modifier
                        .height(26.dp)
                        .width(70.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        Spacer(
            modifier = Modifier
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.8f)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.weight(1f))
        Spacer(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(fraction = 0.7f)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

}


@Preview(showSystemUi = true)
@Composable
private fun Test() {
    ShimmerDetailScreen()
}