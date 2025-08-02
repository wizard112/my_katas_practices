package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.data.extensions.fizzBuzz
import org.junit.Assert
import org.junit.Test

class FizzBuzzTest {
    @Test
    fun `prints fizz instead of the number if the number is a multiple of three`() {
        Assert.assertEquals("Fizz", 3.fizzBuzz())
        Assert.assertEquals("Fizz", 6.fizzBuzz())
        Assert.assertEquals("Fizz", 9.fizzBuzz())
    }
}