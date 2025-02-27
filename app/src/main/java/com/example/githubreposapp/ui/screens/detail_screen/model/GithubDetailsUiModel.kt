package com.example.githubreposapp.ui.screens.detail_screen.model

data class GithubDetailsUiModel(
    val id:Int,
    val name: String,
    val avatar: String,
    val description: String,
    val forks: Int,
    val language: String,
    val fullName: String,
    val stars: Int,
    val owner: String,
)
