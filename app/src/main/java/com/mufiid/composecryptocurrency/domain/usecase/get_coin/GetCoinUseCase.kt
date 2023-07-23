package com.mufiid.composecryptocurrency.domain.usecase.get_coin

import com.mufiid.composecryptocurrency.common.Resource
import com.mufiid.composecryptocurrency.data.remote.dto.toDomain
import com.mufiid.composecryptocurrency.domain.model.CoinDetail
import com.mufiid.composecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(coinId).toDomain()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}