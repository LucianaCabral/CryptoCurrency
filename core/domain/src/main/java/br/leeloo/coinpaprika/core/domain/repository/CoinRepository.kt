package br.leeloo.coinpaprika.core.domain.repository

import br.leeloo.coinpaprika.core.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getCoins(): Flow<List<Coin>>
}