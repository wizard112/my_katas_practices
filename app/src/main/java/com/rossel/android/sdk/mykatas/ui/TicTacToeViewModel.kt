package com.rossel.android.sdk.mykatas.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.rossel.android.sdk.mykatas.data.exception.TicTacToeException
import com.rossel.android.sdk.mykatas.domain.entity.Game
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TicTacToeViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<TicTactToeUiState> = MutableStateFlow(TicTactToeUiState(loading = true, error = null))
    val uiState: StateFlow<TicTactToeUiState> = _uiState.asStateFlow()

    private val _enableButton = MutableStateFlow(true)
    val enableButton: StateFlow<Boolean> = _enableButton.asStateFlow()

    private val _playerName = MutableStateFlow("")
    val playerName: StateFlow<String> = _playerName.asStateFlow()

    private val game: Game = Game()
    val mutableBoard = mutableStateListOf<Symbols>()
    init {
        mutableBoard.addAll(elements = giveMeSymbols())
    }

    fun handleIntents(intent: TicTacToeIntents) {
        when(intent) {
            TicTacToeIntents.Start -> {
                _uiState.update { it.copy(
                    loading = false,
                    error = null,
                    symbols = giveMeSymbols()
                ) }
            }
            is TicTacToeIntents.MakeMove -> {
                try {
                    game.play(intent.position)
                    mutableBoard.clear()
                    mutableBoard.addAll(elements = giveMeSymbols())
                    _uiState.update { it.copy(
                        loading = false,
                        error = null,
                        symbols = giveMeSymbols()
                    ) }
                    _enableButton.update { !game.isOver }
                    _playerName.update { game.player().symbol.name }
                } catch (ex: TicTacToeException) {
                    ex.printStackTrace()
                    _uiState.update { it.copy(
                        loading = false,
                        error = ex.msg,
                        symbols = giveMeSymbols()
                    ) }
                }
            }
        }
    }

    private fun giveMeSymbols(): List<Symbols> = game.board.giveMeBoard().values.map { it.symbol }
}