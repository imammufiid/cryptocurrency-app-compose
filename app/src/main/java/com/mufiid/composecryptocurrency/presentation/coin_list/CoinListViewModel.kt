package com.mufiid.composecryptocurrency.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mufiid.composecryptocurrency.common.Resource
import com.mufiid.composecryptocurrency.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {
    private val _coinsState = mutableStateOf(CoinsState())
    val coinsState: State<CoinsState> = _coinsState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _coinsState.value = CoinsState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _coinsState.value = CoinsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _coinsState.value = CoinsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}