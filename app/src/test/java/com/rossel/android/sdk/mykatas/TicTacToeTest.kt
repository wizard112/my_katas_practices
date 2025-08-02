package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.data.exception.TicTacToeException
import com.rossel.android.sdk.mykatas.domain.entity.Game
import org.junit.Assert
import org.junit.Test

class TicTacToeTest {

    private val ticTacToe = Game()

    @Test
    fun `should win when all fields in a row 1 are taken by the player X`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 4)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 5)
        ticTacToe.play(position = 3)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should win when all fields in a row 2 are taken by the player O`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 4)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 5)
        ticTacToe.play(position = 7)
        ticTacToe.play(position = 6)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should win when all fields in a row 3 are taken by the player X`() {
        ticTacToe.play(position = 7)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 8)
        ticTacToe.play(position = 3)
        ticTacToe.play(position = 9)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should win when all fields in a column 1 are taken by the player O`() {
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 5)
        ticTacToe.play(position = 4)
        ticTacToe.play(position = 3)
        ticTacToe.play(position = 7)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should win when all fields in a column 2 are taken by the player O`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 9)
        ticTacToe.play(position = 5)
        ticTacToe.play(position = 6)
        ticTacToe.play(position = 8)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should win when all fields in a column 3 are taken by the player O`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 3)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 6)
        ticTacToe.play(position = 8)
        ticTacToe.play(position = 9)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should win when all fields in a diagonal 1 are taken by the player X`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 5)
        ticTacToe.play(position = 3)
        ticTacToe.play(position = 9)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should win when all fields in a diagonal 2 are taken by the player X`() {
        ticTacToe.play(position = 7)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 3)
        ticTacToe.play(position = 8)
        ticTacToe.play(position = 5)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test
    fun `should finished when all fields are taken`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 5)
        ticTacToe.play(position = 3)
        ticTacToe.play(position = 6)
        ticTacToe.play(position = 4)
        ticTacToe.play(position = 7)
        ticTacToe.play(position = 8)
        ticTacToe.play(position = 9)
        Assert.assertEquals(true, ticTacToe.isOver)
    }

    @Test(expected = TicTacToeException::class)
    fun `should send exception when user tries to take in an non empty field`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 1)
    }

    @Test(expected = TicTacToeException::class)
    fun `should send exception when user tries to take a field after the game is finished`() {
        ticTacToe.play(position = 1)
        ticTacToe.play(position = 2)
        ticTacToe.play(position = 5)
        ticTacToe.play(position = 3)
        ticTacToe.play(position = 6)
        ticTacToe.play(position = 4)
        ticTacToe.play(position = 7)
        ticTacToe.play(position = 8)
        ticTacToe.play(position = 9)
        ticTacToe.play(position = 3)
    }

}