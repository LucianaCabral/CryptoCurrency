package br.leeloo.coinpaprika.core.domain.domain

import br.leeloo.coinpaprika.core.domain.model.Coin

internal object StubCoin {
    fun getDetails(): Coin {
        return Coin(
            id = "btc-bitcoin",
            name = "Ethereum",
            symbol = "ETH",
            rank = 1,
            isActive = true,
            isNew = false,
            type = "coin"
        )
    }

     fun coinsDataList(): List<Coin> {
        return listOf(
            getDetails(),
            getDetails(),
            getDetails()
        )
    }
}
