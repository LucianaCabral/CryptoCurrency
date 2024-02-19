package br.leeloo.catpaprika.coins.data.repository

import br.leeloo.catpaprika.coins.data.source.CoinDataSource
import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

internal class CoinRepositoryImpl(
    private val coinDataSource: CoinDataSource
) : CoinRepository {
    override suspend fun getCoins(): Flow<List<Coin>> {
        return coinDataSource.getCoins()
    }
}
