package com.rossel.android.sdk.mykatas.ui

import androidx.lifecycle.ViewModel
import com.rossel.android.sdk.mykatas.data.exception.TicTacToeException
import com.rossel.android.sdk.mykatas.domain.entity.Game
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TicTacToeViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<TicTacToeState> = MutableStateFlow(TicTacToeState.Loading)
    val uiState: StateFlow<TicTacToeState> = _uiState.asStateFlow()

    private val game: Game = Game()

    fun handleIntents(intent: TicTacToeIntents) {
        when(intent) {
            TicTacToeIntents.Start -> { updateState(gameState = "Player ${game.player().symbol.name} is your turn") }
            is TicTacToeIntents.MakeMove -> {
                try {
                    val actualPlayer = game.player().symbol.name
                    game.play(intent.position)
                    val text = if (game.isOver) {
                        "Game is over ! Player $actualPlayer is the winner"
                    } else {
                        "Player ${game.player().symbol.name} is your turn"
                    }
                    updateState(gameState = text)
                } catch (ex: TicTacToeException) {
                    ex.printStackTrace()
                    updateState(gameState = "the ${intent.position} is already taken", errorMsg = ex.msg)
                }
            }
        }
    }

    private fun updateState(gameState: String, errorMsg: String = "") {
        _uiState.update {
            TicTacToeState.Symbols(
                symbols = giveMeSymbols(),
                name = gameState,
                enable = !game.isOver,
                error = errorMsg)
        }
    }

    private fun giveMeSymbols(): List<Symbols> = game.board.giveMeBoard().values.map { it.symbol }
}