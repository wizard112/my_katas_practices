package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.domain.entity.TicTacToe
import org.junit.Assert
import org.junit.Test

class TicTacToeTest {

    private val ticTacToe = TicTacToe()

    @Test
    fun `should the game is over when all fields in a row are taken by a player`() {
        ticTacToe.play(column = 1, row = 1, player = "X")
        ticTacToe.play(column = 1, row = 2, player = "O")
        ticTacToe.play(column = 1, row = 3, player = "X")
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a column are taken by a player`() {
        ticTacToe.play(column = 1, row = 1, player = "X")
        ticTacToe.play(column = 2, row = 1, player = "X")
        ticTacToe.play(column = 3, row = 1, player = "X")
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a diagonal are taken by a player`() {
        ticTacToe.play(column = 1, row = 1, player = "X")
        ticTacToe.play(column = 5, row = 1, player = "O")
        ticTacToe.play(column = 9, row = 1, player = "O")
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields are taken`() {
        ticTacToe.play(column = 1, row = 1, player = "O")
        ticTacToe.play(column = 2, row = 1, player = "0")
        ticTacToe.play(column = 3, row = 1, player = "X")
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }
}