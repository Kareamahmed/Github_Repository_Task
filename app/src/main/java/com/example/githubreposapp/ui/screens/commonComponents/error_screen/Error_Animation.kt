package com.example.githubreposapp.ui.screens.commonComponents.error_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.AsyncUpdates
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.githubreposapp.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun ErrorAnimation(composition: LottieComposition?) {
// control animation state
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true, // Ensure the animation plays immediately
        restartOnPlay = true // Restart the animation when it starts playing
    )
// Display the animation
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(420.dp),
        asyncUpdates = AsyncUpdates.ENABLED
    )

}

@Preview(showSystemUi = true, device = Devices.PIXEL_6A)
@Composable
private fun TestPrev() {

}