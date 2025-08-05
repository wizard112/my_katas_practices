package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.ui.TicTacToeState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlin.test.Test

class TicTacToeStateTest {
    @Test
    fun `should create Loading state`() {
        val state = TicTacToeState.Loading

        assertTrue(state is TicTacToeState.Loading)
    }

    @Test
    fun `should create Symbols state with correct values`() {
        val symbols = listOf(Symbols.X, Symbols.O, Symbols.EMPTY)
        val name = "Player X"
        val enable = true
        val error = ""

        val state = TicTacToeState.Symbols(symbols, name, enable, error)

        assertTrue(state is TicTacToeState.Symbols)
        assertEquals(symbols, state.symbols)
        assertEquals(name, state.name)
        assertEquals(enable, state.enable)
        assertEquals(error, state.error)
    }
}