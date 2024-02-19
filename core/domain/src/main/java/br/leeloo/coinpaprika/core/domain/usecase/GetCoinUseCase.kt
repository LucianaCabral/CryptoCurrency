package br.leeloo.coinpaprika.core.domain.usecase

import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend fun invoke(): Flow<List<Coin>> = repository.getCoins()
}