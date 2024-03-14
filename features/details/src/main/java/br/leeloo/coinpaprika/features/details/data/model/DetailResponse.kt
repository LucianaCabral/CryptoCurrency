package br.leeloo.coinpaprika.features.details.data.model

import com.google.gson.annotations.SerializedName

internal data class DetailResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("team")
    val team: List<Team>,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper,
)

internal data class Tag(
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("coin_counter")
    val coinCounter: Int = 0,
    @SerializedName("ico_counter")
    val icoCounter: Int = 0,
)

internal data class Team(
    val id: String = "",
    val name: String = "",
    val position: String = ""
)

internal data class Whitepaper(
    val link: String,
    val thumbnail: String
)

