package br.leeloo.coinpaprika.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface CoinNavigation {
    fun navigateToCoin(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}
