package com.rossel.android.sdk.mykatas

import org.junit.Assert
import org.junit.Test

class TicTacToeTest {

    @Test
    fun `should the game is over when all fields in a row are taken by a player`() {
        Assert.assertEquals(true, isGameOver())
    }
}