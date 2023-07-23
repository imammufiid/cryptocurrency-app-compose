package com.mufiid.composecryptocurrency.domain.repository

import com.mufiid.composecryptocurrency.data.remote.dto.CoinDetailDto
import com.mufiid.composecryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoin(coinId: String): CoinDetailDto
}