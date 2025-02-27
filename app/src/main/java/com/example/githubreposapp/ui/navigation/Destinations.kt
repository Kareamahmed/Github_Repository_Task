package com.example.githubreposapp.ui.navigation

sealed class Destinations(val route: String) {
    data object RepoScreen : Destinations(route = "repo_screen")

    data object DetailScreen : Destinations(route = "detail_screen/{owner}/{name}") {
        fun passOwnerAndName(owner: String, name: String):String{
            return "detail_screen/$owner/$name"
        }
    }

    data object IssueScreen : Destinations(route = "issue_screen/{owner}/{name}") {
        fun passOwnerAndName(owner: String, name: String):String{
            return "issue_screen/$owner/$name"
        }
    }
}