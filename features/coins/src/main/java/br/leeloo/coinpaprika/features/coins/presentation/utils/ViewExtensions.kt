package br.leeloo.coinpaprika.features.coins.presentation.utils

import br.leeloo.coinpaprika.core.domain.model.Coin

internal fun coinDataPreview(name: String = "Vitalik Buterin") = Coin(
    id = "Ethereum",
    name= "Ethereum",
    symbol = "ETH",
    rank = 1,
    isNew = false,
    isActive = true,
    type = "Coin"
)
