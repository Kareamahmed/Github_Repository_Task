package com.example.githubreposapp.ui.mapper

import com.example.githubreposapp.domain.model.CustomExceptionDomainModel
import com.example.githubreposapp.ui.model.CustomExceptionUiModel

fun CustomExceptionDomainModel.toCustomExceptionUiModel(): CustomExceptionUiModel {
    return when (this) {
        is CustomExceptionDomainModel.NoInternetConnectionExceptionDomainModel -> CustomExceptionUiModel.NoInternetConnection
        is CustomExceptionDomainModel.AccessDeniedExceptionDomainModel,
        CustomExceptionDomainModel.ServiceUnavailableExceptionDomainModel,
        CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel -> CustomExceptionUiModel.ServiceUnreachable
        is CustomExceptionDomainModel.TimeOutExceptionDomainModel->CustomExceptionUiModel.TimeOut
        else ->CustomExceptionUiModel.UnKnown

    }
}