package com.rossel.android.sdk.mykatas.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rossel.android.sdk.mykatas.ui.compose.screens.TicTacToeScreen

class TictTacToeActivity: AppCompatActivity() {
    private val ticTacToeViewModel: TicTacToeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TicTacToeScreen(viewModel = ticTacToeViewModel)
        }
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.Start)
    }
}