package com.mufiid.composecryptocurrency.presentation.coin_list

import com.mufiid.composecryptocurrency.domain.model.Coin

data class CoinsState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
