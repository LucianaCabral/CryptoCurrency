package br.leeloo.coinpaprika.core.domain.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface CoinNavigation {
    fun navigateToCoin(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}