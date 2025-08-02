package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.domain.entity.Game
import org.junit.Assert
import org.junit.Test

class TicTacToeTest {

    private val ticTacToe = Game()

    @Test
    fun `should win when all fields in a row 1 are taken by the player X`() {
        var isGameOver = ticTacToe.play(position = 1, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 2, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 3,  player = ticTacToe.playerOne)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should win when all fields in a row 2 are taken by the player O`() {
        var isGameOver = ticTacToe.play(position = 4, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 5, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 6, player = ticTacToe.playerTwo)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should win when all fields in a row 3 are taken by the player X`() {
        var isGameOver = ticTacToe.play(position = 7, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 8, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 9,  player = ticTacToe.playerOne)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should win when all fields in a column 1 are taken by the player O`() {
        var isGameOver = ticTacToe.play(position = 1, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 4, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 7,  player = ticTacToe.playerTwo)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should win when all fields in a column 2 are taken by the player O`() {
        var isGameOver = ticTacToe.play(position = 2, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 5, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 8,  player = ticTacToe.playerTwo)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should win when all fields in a column 3 are taken by the player O`() {
        var isGameOver = ticTacToe.play(position = 3, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 6, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 9,  player = ticTacToe.playerTwo)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should win when all fields in a diagonal 1 are taken by the player X`() {
        var isGameOver = ticTacToe.play(position = 1, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 5, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 9,  player = ticTacToe.playerOne)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should win when all fields in a diagonal 2 are taken by the player X`() {
        var isGameOver = ticTacToe.play(position = 7, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 3, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 5,  player = ticTacToe.playerOne)
        Assert.assertEquals(true, isGameOver)
    }

    @Test
    fun `should finished when all fields are taken`() {
        var isGameOver = ticTacToe.play(position = 1, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 2, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 3, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 4, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 5, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 6, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 7, player = ticTacToe.playerOne)
        isGameOver = ticTacToe.play(position = 8, player = ticTacToe.playerTwo)
        isGameOver = ticTacToe.play(position = 9, player = ticTacToe.playerTwo)
        Assert.assertEquals(true, isGameOver)
    }
}