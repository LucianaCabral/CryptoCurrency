package br.leeloo.coinpaprika.features.details.data.mapper

import br.leeloo.coinpaprika.features.details.data.model.DetailResponse
import br.leeloo.coinpaprika.features.details.domain.model.Detail
import br.leeloo.coinpaprika.features.details.domain.model.Tag
import br.leeloo.coinpaprika.features.details.domain.model.Team

internal fun DetailResponse?.toDetail(): Detail {
    return Detail(
        id = this?.id.orEmpty(),
        description = this?.description.orEmpty(),
        firstDataAt = this?.firstDataAt.orEmpty(),
        logo = this?.logo.orEmpty(),
        isActive = this?.isActive ?: false,
        message = this?.message.orEmpty(),
        name = this?.name.orEmpty(),
        openSource = this?.openSource ?: false,
        rank = this?.rank ?: 0,
        tags = this?.tags?.map { Tag(it.name) }.orEmpty(),
        symbol = this?.symbol.orEmpty(),
        team = this?.team?.map { Team(it.name, it.position) }.orEmpty()
    )
}
