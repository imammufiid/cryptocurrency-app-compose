package com.mufiid.composecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.mufiid.composecryptocurrency.domain.model.Coin

data class CoinDto(
    val id: String?,
    @SerializedName("is_active")
    val isActive: Boolean?,
    @SerializedName("is_new")
    val isNew: Boolean?,
    val name: String?,
    val rank: Int?,
    val symbol: String?,
    val type: String?
)

fun CoinDto.toDomain(): Coin {
    return Coin(
        id = id.orEmpty(),
        isActive = isActive ?: false,
        name = name.orEmpty(),
        rank = rank ?: 0,
        symbol = symbol.orEmpty(),
    )
}