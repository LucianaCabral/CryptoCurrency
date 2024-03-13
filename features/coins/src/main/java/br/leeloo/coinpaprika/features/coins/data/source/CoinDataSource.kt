package br.leeloo.coinpaprika.features.coins.data.source

import br.leeloo.coinpaprika.core.domain.model.Coin
import kotlinx.coroutines.flow.Flow

internal interface CoinDataSource {
    fun getCoins(): Flow<List<Coin>>
}
