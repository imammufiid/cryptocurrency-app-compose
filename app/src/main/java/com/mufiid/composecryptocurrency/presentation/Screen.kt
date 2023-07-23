package com.mufiid.composecryptocurrency.presentation

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coins")
    object CoinDetailScreen: Screen("coin")
}
