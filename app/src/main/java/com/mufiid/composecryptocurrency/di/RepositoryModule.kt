package com.mufiid.composecryptocurrency.di

import com.mufiid.composecryptocurrency.data.remote.CoinPaprikaApi
import com.mufiid.composecryptocurrency.data.repository.CoinRepositoryImpl
import com.mufiid.composecryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api = api)
    }
}