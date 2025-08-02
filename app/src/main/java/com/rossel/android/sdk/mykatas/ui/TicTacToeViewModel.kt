package com.rossel.android.sdk.mykatas.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.rossel.android.sdk.mykatas.data.exception.TicTacToeException
import com.rossel.android.sdk.mykatas.domain.entity.Game
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TicTacToeViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<TicTactToeUiState> = MutableStateFlow(TicTactToeUiState(loading = true, board = false, error = null))
    val uiState: StateFlow<TicTactToeUiState> = _uiState.asStateFlow()

    private val game: Game = Game()
    val mutableBoard = mutableListOf<Symbols>()
    init {
        mutableBoard.addAll(elements = giveMeSymbols())
    }

    fun handleIntents(intent: TicTacToeIntents) {
        when(intent) {
            TicTacToeIntents.Start -> {
                _uiState.update { it.copy(
                    loading = false,
                    board = true,
                    error = null
                ) }
            }
            is TicTacToeIntents.Play -> {
                try {
                    game.play(intent.position)
                    mutableBoard.clear()
                    mutableBoard.addAll(elements = giveMeSymbols())
                    mutableBoard.forEach { item -> Log.d("TESTTICTACTOE","---- ${item.name} ----") }
                } catch (ex: TicTacToeException) {
                    ex.printStackTrace()
                    _uiState.update { it.copy(
                        loading = false,
                        board = true,
                        error = ex.msg
                    ) }
                }
            }
        }
    }

    private fun giveMeSymbols(): List<Symbols> = game.board.giveMeBoard().values.map { it.symbol }
}