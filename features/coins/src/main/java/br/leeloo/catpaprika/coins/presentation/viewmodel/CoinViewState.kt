package br.leeloo.catpaprika.coins.presentation.viewmodel

import br.leeloo.coinpaprika.core.domain.model.Coin

internal data class CoinViewState(
    val shouldShowLoading: Boolean = false,
    val coins: List<Coin> = emptyList()
) {
    fun handleSuccessState(coins: List<Coin>) = copy(
        coins = coins
    )

    fun handleErrorState() = copy(
        shouldShowLoading = false,
        coins = emptyList()
    )
}
