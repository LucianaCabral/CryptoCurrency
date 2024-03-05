package br.leeloo.catpaprika.coins.data.repository

import br.leeloo.catpaprika.coins.data.source.CoinDataSource
import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class CoinRepositoryImpl @Inject constructor(
    private val coinDataSource: CoinDataSource
) : CoinRepository {
    override fun getCoins(): Flow<List<Coin>> {
       return coinDataSource.getCoins()
    }
}
