package com.mufiid.composecryptocurrency.data.repository

import com.mufiid.composecryptocurrency.data.remote.CoinPaprikaApi
import com.mufiid.composecryptocurrency.data.remote.dto.CoinDetailDto
import com.mufiid.composecryptocurrency.data.remote.dto.CoinDto
import com.mufiid.composecryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}