package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.data.exception.TicTacToeException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExceptionTest {
    @Test
    fun `should store and return correct exception message`() {
        val message = "Invalid move"
        val exception = TicTacToeException(message)

        assertEquals(message, exception.message)
        assertTrue(exception is Exception)
    }
}