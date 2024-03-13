package br.leeloo.coinpaprika.features.coins.presentation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
}
