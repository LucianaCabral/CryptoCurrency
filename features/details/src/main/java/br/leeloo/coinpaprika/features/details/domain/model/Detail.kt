package br.leeloo.coinpaprika.features.details.domain.model

internal data class Detail(
    val id: String = "",
    val description: String= "",
    val firstDataAt: String="",
    val logo: String = "",
    val isActive: Boolean = true,
    val lastDataAt: String = "",
    val message: String = "",
    val name: String = "",
    val openSource: Boolean = true,
    val rank: Int = 0,
    val tags: List<Tag>? = emptyList(),
    val symbol: String = "",
    val team: List<Team>? = emptyList(),
)

internal data class Tag(
    val name: String,
)

internal data class Team (
    val name: String,
    val position: String
)
