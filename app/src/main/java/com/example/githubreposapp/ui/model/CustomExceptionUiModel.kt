package com.example.githubreposapp.ui.model



sealed class CustomExceptionUiModel {
    data object NoInternetConnection : CustomExceptionUiModel()
    data object TimeOut :CustomExceptionUiModel()
    data object ServiceUnreachable :CustomExceptionUiModel()
    data object UnKnown :CustomExceptionUiModel()
}