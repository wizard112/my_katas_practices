package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.data.extensions.fizzBuzz
import org.junit.Assert
import org.junit.Test

class ExtensionsText {

    @Test
    fun `should Fizz when number is a multiple of 3`() {
        Assert.assertEquals("Fizz", 6.fizzBuzz())
    }

    @Test
    fun `should FizzBuzz when number is a multiple of both 5 and 3 `() {
        Assert.assertEquals("FizzBuzz", 15.fizzBuzz())
    }

    @Test
    fun `should Buzz when number is a multiple of 5`() {
        Assert.assertEquals("Buzz", 20.fizzBuzz())
    }
}