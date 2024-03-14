package br.leeloo.coinpaprika.features.details.presentation.viewmodel

import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.features.details.domain.model.Detail

internal data class DetailViewState(
    val detail: Detail = Detail(),
    val errorMessage: String = "",
    val shouldShowLoading: Boolean = false,
    val shouldCollapseText: Boolean = true,
    val coins: List<Coin> = emptyList()
) {
    fun setSuccessState(detail: Detail): DetailViewState {
        return copy(detail = detail)
    }
}
