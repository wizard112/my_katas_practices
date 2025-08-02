package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.domain.entity.TicTacToe
import org.junit.Assert
import org.junit.Test

class TicTacToeTest {

    private val ticTacToe = TicTacToe()

    @Test
    fun `should the game is over when all fields in a row 1 are taken by a player`() {
        ticTacToe.play(position = 1, player = ticTacToe.playerO)
        ticTacToe.play(position = 2, player = ticTacToe.playerO)
        ticTacToe.play(position = 3,  player = ticTacToe.playerO)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a row 2 are taken by a player`() {
        ticTacToe.play(position = 4, player = ticTacToe.playerX)
        ticTacToe.play(position = 5, player = ticTacToe.playerX)
        ticTacToe.play(position = 6, player = ticTacToe.playerX)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a row 3 are taken by a player`() {
        ticTacToe.play(position = 7, player = ticTacToe.playerX)
        ticTacToe.play(position = 8, player = ticTacToe.playerX)
        ticTacToe.play(position = 9,  player = ticTacToe.playerX)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a column 1 are taken by a player`() {
        ticTacToe.play(position = 1, player = ticTacToe.playerX)
        ticTacToe.play(position = 4, player = ticTacToe.playerX)
        ticTacToe.play(position = 7,  player = ticTacToe.playerX)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a column 2 are taken by a player`() {
        ticTacToe.play(position = 2, player = ticTacToe.playerX)
        ticTacToe.play(position = 5, player = ticTacToe.playerX)
        ticTacToe.play(position = 8,  player = ticTacToe.playerX)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a column 3 are taken by a player`() {
        ticTacToe.play(position = 3, player = ticTacToe.playerX)
        ticTacToe.play(position = 6, player = ticTacToe.playerX)
        ticTacToe.play(position = 9,  player = ticTacToe.playerX)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a diagonal 1 are taken by a player`() {
        ticTacToe.play(position = 1, player = ticTacToe.playerO)
        ticTacToe.play(position = 5, player = ticTacToe.playerO)
        ticTacToe.play(position = 9,  player = ticTacToe.playerO)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields in a diagonal 2 are taken by a player`() {
        ticTacToe.play(position = 7, player = ticTacToe.playerO)
        ticTacToe.play(position = 3, player = ticTacToe.playerO)
        ticTacToe.play(position = 5,  player = ticTacToe.playerO)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }

    @Test
    fun `should the game is over when all fields are taken`() {
        ticTacToe.play(position = 1, player = ticTacToe.playerO)
        ticTacToe.play(position = 2, player = ticTacToe.playerX)
        ticTacToe.play(position = 3, player = ticTacToe.playerX)
        ticTacToe.play(position = 4, player = ticTacToe.playerX)
        ticTacToe.play(position = 5, player = ticTacToe.playerO)
        ticTacToe.play(position = 6, player = ticTacToe.playerO)
        ticTacToe.play(position = 7, player = ticTacToe.playerO)
        ticTacToe.play(position = 8, player = ticTacToe.playerX)
        ticTacToe.play(position = 9, player = ticTacToe.playerX)
        Assert.assertEquals(true, ticTacToe.isGameOver())
    }
}