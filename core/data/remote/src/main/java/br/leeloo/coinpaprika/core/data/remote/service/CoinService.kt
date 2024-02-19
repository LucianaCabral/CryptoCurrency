package br.leeloo.coinpaprika.core.data.remote.service

import br.leeloo.coinpaprika.core.data.remote.model.CoinResponse
import retrofit2.http.GET

interface CoinService {
    @GET("movie/popular")
    suspend fun getCoins(
    ): List<CoinResponse>
}