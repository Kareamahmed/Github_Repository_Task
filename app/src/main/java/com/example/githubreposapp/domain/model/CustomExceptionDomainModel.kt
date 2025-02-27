package com.example.githubreposapp.domain.model

sealed class CustomExceptionDomainModel : Exception() {
   data object NoInternetConnectionExceptionDomainModel:CustomExceptionDomainModel() {
        private fun readResolve(): Any = NoInternetConnectionExceptionDomainModel
    }
    data object TimeOutExceptionDomainModel:CustomExceptionDomainModel() {
        private fun readResolve(): Any = NoInternetConnectionExceptionDomainModel
    }
    data object ServiceNotFoundExceptionDomainModel:CustomExceptionDomainModel() {
        private fun readResolve(): Any = NoInternetConnectionExceptionDomainModel
    }
    data object AccessDeniedExceptionDomainModel:CustomExceptionDomainModel() {
        private fun readResolve(): Any = NoInternetConnectionExceptionDomainModel
    }
    data object ServiceUnavailableExceptionDomainModel:CustomExceptionDomainModel() {
        private fun readResolve(): Any = NoInternetConnectionExceptionDomainModel
    }
    data object UnKnownExceptionDomainModel:CustomExceptionDomainModel() {
        private fun readResolve(): Any = NoInternetConnectionExceptionDomainModel
    }
}
