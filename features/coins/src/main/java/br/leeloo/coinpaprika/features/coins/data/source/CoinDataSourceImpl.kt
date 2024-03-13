package br.leeloo.coinpaprika.features.coins.data.source

import br.leeloo.coinpaprika.core.data.remote.model.toCoins
import br.leeloo.coinpaprika.core.data.remote.service.CoinService
import br.leeloo.coinpaprika.core.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class CoinDataSourceImpl @Inject constructor(
    private val service: CoinService
) : CoinDataSource {
    override fun getCoins(): Flow<List<Coin>> {
        return flow {
           emit(service.getCoins().toCoins()) }
    }
}
