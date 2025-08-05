package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.ui.TicTacToeIntents
import com.rossel.android.sdk.mykatas.ui.TicTacToeState
import com.rossel.android.sdk.mykatas.ui.TicTacToeViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TicTacToeViewModelTest {

    private lateinit var ticTacToeViewModel: TicTacToeViewModel

    @Before
    fun setUp() {
        ticTacToeViewModel = TicTacToeViewModel()
    }

    @Test
    fun `should ui state symbols not empty when the intent is Start`() {
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.Start)
        val state = ticTacToeViewModel.uiState.value
        Assert.assertTrue(state is TicTacToeState.Symbols)
        Assert.assertTrue((state as TicTacToeState.Symbols).error.isEmpty())
        Assert.assertTrue(state.enable)
        Assert.assertTrue(state.symbols.isNotEmpty())
    }

    @Test
    fun `should symbol O when the intent is MakeMove`() {
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 1))
        val state = ticTacToeViewModel.uiState.value
        Assert.assertTrue(state is TicTacToeState.Symbols)
        Assert.assertTrue((state as TicTacToeState.Symbols).symbols.isNotEmpty())
        Assert.assertEquals(Symbols.O, state.symbols[0])
        Assert.assertEquals("Player X is your turn", state.name)
    }

    @Test
    fun `should tic tac toe exception when the intent is MakeMove on a field already taken`() {
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 1))
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 1))
        val state = ticTacToeViewModel.uiState.value
        Assert.assertEquals("The field is already taken", (state as TicTacToeState.Symbols).error)
    }

    @Test
    fun `should the game is over when the player O take all fields of first row`() {
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 5))
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 1))
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 4))
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 2))
        ticTacToeViewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = 6))
        val state = ticTacToeViewModel.uiState.value
        Assert.assertEquals("Game is over ! Player O is the winner", (state as TicTacToeState.Symbols).name)
    }
}