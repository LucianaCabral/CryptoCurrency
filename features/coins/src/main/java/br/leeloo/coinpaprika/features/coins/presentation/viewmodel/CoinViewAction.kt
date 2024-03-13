package br.leeloo.coinpaprika.features.coins.presentation.viewmodel

internal sealed class CoinViewAction {
    data class ItemClicked(val id: String) : CoinViewAction()
}
