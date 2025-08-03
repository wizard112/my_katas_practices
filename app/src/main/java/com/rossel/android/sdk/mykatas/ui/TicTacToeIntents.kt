package com.rossel.android.sdk.mykatas.ui


sealed class TicTacToeIntents {
    object Start: TicTacToeIntents()
    class MakeMove (val position: Int): TicTacToeIntents()
}