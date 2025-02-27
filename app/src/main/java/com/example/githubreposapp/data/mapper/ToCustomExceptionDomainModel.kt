package com.example.githubreposapp.data.mapper


import com.example.githubreposapp.domain.model.CustomExceptionDomainModel
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

fun Throwable.toCustomExceptionDomainModel() : CustomExceptionDomainModel {
    return when (this) {
        is InterruptedException -> CustomExceptionDomainModel.TimeOutExceptionDomainModel
        is IOException -> CustomExceptionDomainModel.NoInternetConnectionExceptionDomainModel
        is HttpException -> {
            when (this.code ()) {
                HttpURLConnection.HTTP_NOT_FOUND -> CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel

                HttpURLConnection.HTTP_FORBIDDEN -> CustomExceptionDomainModel.AccessDeniedExceptionDomainModel

                HttpURLConnection.HTTP_UNAVAILABLE -> CustomExceptionDomainModel.ServiceUnavailableExceptionDomainModel

                else -> CustomExceptionDomainModel.UnKnownExceptionDomainModel
            }
        }
        else -> CustomExceptionDomainModel.UnKnownExceptionDomainModel
    }
}