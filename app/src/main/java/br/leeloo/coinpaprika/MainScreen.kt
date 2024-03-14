package br.leeloo.coinpaprika

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import br.leeloo.coinpaprika.core.navigation.CoinNavigation
import br.leeloo.coinpaprika.core.navigation.DetailNavigation

@Composable
fun MainScreen(
    navController: NavHostController,
    coinNavigation: CoinNavigation,
    detailNavigation: DetailNavigation
) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier.padding(paddingValues = it)
            ) {
                AppNavigationGraph(
                    navController = navController,
                    coinNavigation = coinNavigation,
                    detailNavigation = detailNavigation
                )
            }
        }
    )
}
