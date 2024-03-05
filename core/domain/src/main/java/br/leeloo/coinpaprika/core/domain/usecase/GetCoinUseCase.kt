package br.leeloo.coinpaprika.core.domain.usecase

import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
     operator fun invoke(): Flow<List<Coin>> = repository.getCoins().apply {
        println("<L> usercase this = ${this}")
        println("<L> usercase = ${repository.getCoins()}")
    }
}