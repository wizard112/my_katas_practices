package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.domain.entity.TicTacToe
import org.junit.Assert
import org.junit.Test

class TicTacToeTest {

    private val ticTacToe = TicTacToe()

    @Test
    fun `should the game is over when all fields in a row are taken by a player`() {
        Assert.assertEquals(true, ticTacToe.isGameOver(column = 1))
    }

    @Test
    fun `should the game is over when all fields in a column are taken by a player`() {
        Assert.assertEquals(true, ticTacToe.isGameOver(column = 1))
    }

    @Test
    fun `should the game is over when all fields in a diagonal are taken by a player`() {
        Assert.assertEquals(true, ticTacToe.isGameOver(column = 1))
    }

    @Test
    fun `should the game is over when all fields are taken`() {
        Assert.assertEquals(true, ticTacToe.isGameOver(column = 1))
    }
}