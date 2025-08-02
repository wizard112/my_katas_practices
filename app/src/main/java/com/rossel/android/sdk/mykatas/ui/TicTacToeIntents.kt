package com.rossel.android.sdk.mykatas.ui


sealed class TicTacToeIntents {
    object Start: TicTacToeIntents()
    class Play (val position: Int): TicTacToeIntents()
}