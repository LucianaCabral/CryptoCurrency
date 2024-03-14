package br.leeloo.coinpaprika.features.details.presentation.uitls

import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.features.details.domain.model.Detail
import br.leeloo.coinpaprika.features.details.domain.model.Tag
import br.leeloo.coinpaprika.features.details.domain.model.Team

internal fun detailDataPreview(): Detail {
    return Detail(
        id = "btc-bitcoin",
        description = "Bitcoin is a cryptocurrency and worldwide payment system. It is the " +
                "first decentralized digital currency, as the system works without a central bank " +
                "or single administrator.",

        firstDataAt = "2018-10-03T11:48:19Z",
        logo = "https://static.coinpaprika.com/coin/bnb-binance-coin/logo.png",
        isActive = true,
        message = "string",
        name = "Ethereum",
        openSource = true,
        rank = 1,
        tags = tagsDataPreview(),
        symbol = "ETH",
        team = teamsDataPreview()
    )
}

internal fun coinDataPreview(name: String = "Vitalik Buterin") = Coin(
    id = "Ethereum",
    name= "Ethereum",
    symbol = "ETH",
    rank = 1,
    isNew = false,
    isActive = true,
    type = "Coin"
)

internal fun teamDataPreview(name: String = "Vitalik Buterin") = Team(
    name = name,
    position = "Author"
)

internal fun teamsDataPreview(): List<Team> {
    return listOf(
        teamDataPreview(name = "Vitalik Buterin"),
        teamDataPreview(name = "Vitalik Buterin"),
        teamDataPreview(name = "Vitalik Buterin"),
        teamDataPreview(name = "Vitalik Buterin"),
    )
}

internal fun tagDataPreview(name: String = "Blockchain Service") = Tag(
    name = name,
)

internal fun tagsDataPreview(): List<Tag> {
    return listOf(
        tagDataPreview(),
        tagDataPreview(),
        tagDataPreview()
    )
}
