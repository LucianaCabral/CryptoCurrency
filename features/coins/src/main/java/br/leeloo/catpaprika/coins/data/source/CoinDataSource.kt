package br.leeloo.catpaprika.coins.data.source

import br.leeloo.coinpaprika.core.domain.model.Coin
import kotlinx.coroutines.flow.Flow

internal interface CoinDataSource {
    suspend fun getCoins(): Flow<List<Coin>>
}
