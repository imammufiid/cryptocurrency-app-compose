package com.mufiid.composecryptocurrency.domain.model


data class Coin(
    val id: String = "",
    val isActive: Boolean = false,
    val name: String = "",
    val rank: Int = 0,
    val symbol: String = "",
)
