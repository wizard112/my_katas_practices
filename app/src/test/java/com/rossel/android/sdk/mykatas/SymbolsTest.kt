package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlin.test.Test

class SymbolsTest {
    @Test
    fun `should contain all expected symbols`() {
        val symbols = Symbols.entries.toList()

        assertTrue(symbols.contains(Symbols.X))
        assertTrue(symbols.contains(Symbols.O))
        assertTrue(symbols.contains(Symbols.EMPTY))
    }

    @Test
    fun `symbol name should match expected`() {
        assertEquals("X", Symbols.X.name)
        assertEquals("O", Symbols.O.name)
        assertEquals("EMPTY", Symbols.EMPTY.name)
    }

    @Test
    fun `valueOf should return correct enum`() {
        assertEquals(Symbols.X, Symbols.valueOf("X"))
        assertEquals(Symbols.O, Symbols.valueOf("O"))
        assertEquals(Symbols.EMPTY, Symbols.valueOf("EMPTY"))
    }
}