package br.leeloo.catpaprika.coins.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.leeloo.catpaprika.coins.presentation.Screen
import br.leeloo.catpaprika.coins.presentation.component.CoinListScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
    navController = navController,
    startDestination = Screen.CoinListScreen.route
    ) {
        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }
    }
}

