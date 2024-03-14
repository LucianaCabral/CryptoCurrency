package br.leeloo.coinpaprika.features.details.data.repository

import br.leeloo.coinpaprika.features.details.data.source.DetailDataSource
import br.leeloo.coinpaprika.features.details.domain.model.Detail
import br.leeloo.coinpaprika.features.details.domain.repository.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DetailRepositoryImpl @Inject constructor(
    private val detailDataSource: DetailDataSource
): DetailRepository {
    override fun getDetails(id: String): Flow<Detail> {
        return detailDataSource.getCoinDetails(id)
    }
}
