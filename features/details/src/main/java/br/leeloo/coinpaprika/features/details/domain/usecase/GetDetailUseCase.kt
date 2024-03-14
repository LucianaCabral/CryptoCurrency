package br.leeloo.coinpaprika.features.details.domain.usecase

import br.leeloo.coinpaprika.features.details.domain.model.Detail
import br.leeloo.coinpaprika.features.details.domain.repository.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetDetailUseCase @Inject constructor(
    private val repository: DetailRepository
) {
    operator fun invoke(id: String): Flow<Detail> =
        repository.getDetails(id)
}
