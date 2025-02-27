package com.example.githubreposapp.ui.screens.commonComponents.shimmer_screen.issues

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubreposapp.ui.screens.commonComponents.shimmer_screen.repos.shimmerEffect

@Composable
fun ShimmerIssues() {
    LazyColumn {
        items(10) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .shimmerEffect(),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(Modifier.padding(vertical = 7.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .height(20.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .shimmerEffect()

                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.3f)
                                .height(20.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .shimmerEffect()
                        )
                    }
                    Spacer(Modifier.padding(top = 15.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .height(20.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .shimmerEffect()
                    )
                    Spacer(Modifier.padding(top = 15.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(25.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .shimmerEffect()
                    )
                }
            }
            HorizontalDivider()
        }
    }
}

@Preview
@Composable
private fun Test() {
    ShimmerIssues()
}