package com.mufiid.composecryptocurrency.presentation.coin_detail

import com.mufiid.composecryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
