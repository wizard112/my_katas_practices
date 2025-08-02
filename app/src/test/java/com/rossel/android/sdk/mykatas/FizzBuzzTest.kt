package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.data.extensions.fizzBuzz
import org.junit.Assert
import org.junit.Test

class FizzBuzzTest {
    @Test
    fun `prints Fizz instead of the number if the number is a multiple of three`() {
        Assert.assertEquals("Fizz", 3.fizzBuzz())
        Assert.assertEquals("Fizz", 6.fizzBuzz())
        Assert.assertEquals("Fizz", 9.fizzBuzz())
    }

    @Test
    fun `prints Buzz instead of the number if the number is a multiple of five`() {
        Assert.assertEquals("Buzz", 5.fizzBuzz())
        Assert.assertEquals("Buzz", 10.fizzBuzz())
    }

    @Test
    fun `prints FizzBuzz instead of the number if the number is a multiple of both three and five`() {
        Assert.assertEquals("FizzBuzz", 15.fizzBuzz())
        Assert.assertEquals("FizzBuzz", 30.fizzBuzz())
        Assert.assertEquals("FizzBuzz", 45.fizzBuzz())
    }
}