package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.ui.TicTacToeIntents
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlin.test.Test

class TicTacToeIntentsTest {
    @Test
    fun `should create Start intent`() {
        val intent = TicTacToeIntents.Start

        assertTrue(intent is TicTacToeIntents.Start)
    }

    @Test
    fun `should create MakeMove intent with correct position`() {
        val position = 4
        val intent = TicTacToeIntents.MakeMove(position)

        assertTrue(intent is TicTacToeIntents.MakeMove)
        assertEquals(position, intent.position)
    }
}