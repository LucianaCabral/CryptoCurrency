package br.leeloo.coinpaprika.features.coins.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.leeloo.coinpaprika.core.navigation.CoinNavigation
import br.leeloo.coinpaprika.features.coins.presentation.Screen

internal class CoinNavigationImpl: CoinNavigation {
    override fun navigateToCoin(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.apply {
            composable(route = CoinNavItem.route) {
                Screen(navController)
            }
        }
    }
}
