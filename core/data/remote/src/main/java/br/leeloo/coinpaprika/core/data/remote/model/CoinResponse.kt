package br.leeloo.coinpaprika.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("symbol")
    val symbol: String? ="",
    @SerializedName("rank")
    val rank: Int? = 0,
    @SerializedName("is_new")
    val isNew: Boolean = false,
    @SerializedName("is_active")
    val isActive: Boolean = false,
    @SerializedName("type")
    val type: String? = ""
)
