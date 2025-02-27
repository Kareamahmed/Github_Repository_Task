package com.example.githubreposapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubreposapp.ui.screens.detail_screen.DetailScreen
import com.example.githubreposapp.ui.screens.issue_screen.IssueScreen
import com.example.githubreposapp.ui.screens.repos_screen.RepoScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.RepoScreen.route) {
        composable(route = Destinations.RepoScreen.route) {
            RepoScreen(
                onItemClick = { owner, name ->
                    navController.navigate(
                        route = Destinations.DetailScreen.passOwnerAndName(
                            owner,
                            name
                        )
                    )
                }
            )
        }
        composable(route = Destinations.DetailScreen.route) { navBackStackEntry ->
            val owner = navBackStackEntry.arguments?.getString("owner")
            val name = navBackStackEntry.arguments?.getString("name")
            owner?.let {
                name?.let {
                    DetailScreen(
                        name = name,
                        owner = owner,
                        onClickButton = {
                            navController.navigate(
                                route = Destinations.IssueScreen.passOwnerAndName(
                                    owner,
                                    name
                                )
                            )
                        },
                        onClickBackArrow = { navController.navigateUp() }
                    )
                }
            }
        }
        composable(route = Destinations.IssueScreen.route) { navBackStackEntry ->
            val owner = navBackStackEntry.arguments?.getString("owner")
            val name = navBackStackEntry.arguments?.getString("name")
            if (owner != null && name != null) {
                IssueScreen(owner = owner, name = name) {
                    navController.navigateUp()
                }
            }
        }
    }
}
