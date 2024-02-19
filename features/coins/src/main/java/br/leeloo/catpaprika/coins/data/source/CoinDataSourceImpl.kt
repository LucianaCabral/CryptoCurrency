package br.leeloo.catpaprika.coins.data.source

import br.leeloo.coinpaprika.core.data.remote.model.toCoins
import br.leeloo.coinpaprika.core.data.remote.service.CoinService
import br.leeloo.coinpaprika.core.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class CoinDataSourceImpl(
    private val service: CoinService
): CoinDataSource {
    override suspend fun getCoins(): Flow<List<Coin>> {
      return flow {
          service.getCoins().toCoins() }
    }
}
