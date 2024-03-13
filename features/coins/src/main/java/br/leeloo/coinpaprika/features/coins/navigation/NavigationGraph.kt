package br.leeloo.coinpaprika.features.coins.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.leeloo.coinpaprika.features.coins.presentation.Screen
import br.leeloo.coinpaprika.features.coins.presentation.component.CoinListScreen

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

