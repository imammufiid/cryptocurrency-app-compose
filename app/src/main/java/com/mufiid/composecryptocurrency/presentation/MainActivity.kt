package com.mufiid.composecryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mufiid.composecryptocurrency.presentation.ui.theme.ComposeCryptocurrencyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCryptocurrencyTheme {
            }
        }
    }
}
