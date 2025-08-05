package com.rossel.android.sdk.mykatas.ui

sealed class TicTacToeState {
    object Loading: TicTacToeState()
    data class Symbols(val symbols: List<com.rossel.android.sdk.mykatas.domain.enums.Symbols>,
                       val name: String,
                       val enable: Boolean,
                       val error: String): TicTacToeState()
}