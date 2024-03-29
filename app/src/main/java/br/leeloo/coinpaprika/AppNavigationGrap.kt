package br.leeloo.coinpaprika

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.leeloo.coinpaprika.core.navigation.CoinNavigation
import br.leeloo.coinpaprika.core.navigation.DetailNavigation
import br.leeloo.coinpaprika.features.coins.navigation.CoinNavItem

@Composable
fun AppNavigationGraph(
    navController: NavHostController,
    coinNavigation: CoinNavigation,
    detailNavigation: DetailNavigation
) {
    NavHost(
        navController = navController,
        startDestination = CoinNavItem.route
    ) {
        coinNavigation.navigateToCoin(navGraphBuilder = this, navController)
        detailNavigation.navigateToDetail(navGraphBuilder= this, navController)
    }
}
