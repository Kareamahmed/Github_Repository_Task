package com.example.githubreposapp.ui.screens.commonComponents.error_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.model.CustomExceptionUiModel
import com.example.githubreposapp.ui.theme.LightGreen
import com.example.githubreposapp.ui.theme.light_background


@Composable
fun ErrorScreen(
    customErrorException: CustomExceptionUiModel,
    onRetryButtonClick: () -> Unit
) {
    val errorMessage = when (customErrorException) {
        is CustomExceptionUiModel.TimeOut -> stringResource(R.string.timeOut_Exception_message)
        is CustomExceptionUiModel.NoInternetConnection -> stringResource(R.string.noInternet_Exception_details)
        is CustomExceptionUiModel.ServiceUnreachable -> stringResource(R.string.service_unreachable_exception_message)
        is CustomExceptionUiModel.UnKnown -> stringResource(R.string.unKnown_Exception_message)
    }

    // Preload the Lottie composition using rememberLottieComposition
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.error_animation)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(light_background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider()
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ErrorAnimation(composition)
        }
        Spacer(modifier = Modifier.padding(top = 30.dp ))
        Text(
            text = stringResource(R.string.some_Thing_wrong),
            style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            modifier = Modifier.padding(15.dp),
            text = errorMessage,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Light)
        )
        Spacer(Modifier.padding(top = 60.dp))
        Button(
            onClick = { onRetryButtonClick() },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(shape = RoundedCornerShape(5.dp))
                .border(color = LightGreen, width = 2.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(text = stringResource(R.string.retry), color = LightGreen, fontSize = 20.sp)
        }

    }
}


@Preview(showBackground = true, device = Devices.PIXEL_6)
@Composable
private fun ErrorScreenPrev() {
   ErrorScreen(
       customErrorException = CustomExceptionUiModel.UnKnown,
       {}
   )
}