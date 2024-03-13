package br.leeloo.coinpaprika.features.details.domain.repository

import br.leeloo.coinpaprika.features.details.domain.model.Detail
import kotlinx.coroutines.flow.Flow

internal interface DetailRepository {
    fun getDetails(id: String): Flow<Detail>
}
