package br.leeloo.coinpaprika.features.coins.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import br.leeloo.catpaprika.coins.R

import br.leeloo.coinpaprika.features.coins.presentation.CoinListComponent

@Composable
fun CoinListScreen(
    navController: NavController,
) {
    val title = LocalContext.current.getString(R.string.coin)
    AppBar(
        title = title,
        content = {
            CoinListComponent(
                navController = navController
            )
        }
    )
}
