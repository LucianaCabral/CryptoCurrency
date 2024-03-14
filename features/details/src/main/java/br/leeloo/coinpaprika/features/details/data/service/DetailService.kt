package br.leeloo.coinpaprika.features.details.data.service

import br.leeloo.coinpaprika.features.details.data.model.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface DetailService {
    @GET("v1/coins/{coin_id}")
    suspend fun getCoinDetail(
        @Path("coin_id") id: String
    ): DetailResponse
}
