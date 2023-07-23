package com.mufiid.composecryptocurrency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mufiid.composecryptocurrency.common.Constants.PARAM_COIN_ID
import com.mufiid.composecryptocurrency.common.Resource
import com.mufiid.composecryptocurrency.domain.usecase.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _coinsState = mutableStateOf(CoinDetailState())
    val coinsState: State<CoinDetailState> = _coinsState

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)
            ?.let { coinId ->
                getCoins(coinId = coinId)
            }
    }

    private fun getCoins(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _coinsState.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _coinsState.value = CoinDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _coinsState.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}