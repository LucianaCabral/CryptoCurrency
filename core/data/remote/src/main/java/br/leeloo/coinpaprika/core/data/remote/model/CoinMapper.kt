package br.leeloo.coinpaprika.core.data.remote.model

import br.leeloo.coinpaprika.core.domain.model.Coin
fun List<CoinResponse>.toCoins() =
    this.map { it.toCoin() }

private fun CoinResponse?.toCoin(): Coin {
    return Coin(
        id = this?.id.orEmpty(),
        name = this?.name.orEmpty(),
        symbol = this?.symbol.orEmpty(),
        rank = this?.rank ?: 0,
        isActive = this?.isActive ?: false,
        isNew = this?.isNew ?: false,
        type = this?.type.orEmpty()
    )
}
