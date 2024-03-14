package br.leeloo.coinpaprika.features.details.data.source

import br.leeloo.coinpaprika.features.details.data.mapper.toDetail
import br.leeloo.coinpaprika.features.details.data.service.DetailService
import br.leeloo.coinpaprika.features.details.domain.model.Detail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class DetailDataSourceImpl(
    private val service: DetailService
): DetailDataSource {
    override fun getCoinDetails(id: String): Flow<Detail> {
        return flow {
            emit(service.getCoinDetail(id).toDetail())
        }
    }
}
