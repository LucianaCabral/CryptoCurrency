package br.leeloo.coinpaprika.features.details.data.source

import br.leeloo.coinpaprika.features.details.domain.model.Detail
import kotlinx.coroutines.flow.Flow

internal interface DetailDataSource {
    fun getCoinDetails(id: String): Flow<Detail>
}

