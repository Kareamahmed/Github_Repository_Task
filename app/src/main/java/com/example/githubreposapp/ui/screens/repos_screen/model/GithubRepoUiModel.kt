package com.example.githubreposapp.ui.screens.repos_screen.model

data class GithubRepoUiModel(
    val id: Int,
    val name:String,
    val avatar:String,
    val description:String,
    val stars:Int,
    val owner:String
    )
