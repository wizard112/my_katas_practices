package com.rossel.android.sdk.mykatas

import com.rossel.android.sdk.mykatas.data.extensions.fizzBuzz
import org.junit.Assert
import org.junit.Test

class FizzBuzzTest {
    @Test
    fun `should prints Fizz when number is a multiple of 3`() {
        Assert.assertEquals("Fizz", 3.fizzBuzz())
        Assert.assertEquals("Fizz", 6.fizzBuzz())
        Assert.assertEquals("Fizz", 9.fizzBuzz())
    }

    @Test
    fun `should prints Buzz when number is a multiple of 5`() {
        Assert.assertEquals("Buzz", 5.fizzBuzz())
        Assert.assertEquals("Buzz", 10.fizzBuzz())
    }

    @Test
    fun `should prints FizzBuzz when number is a multiple of both 3 and 5`() {
        Assert.assertEquals("FizzBuzz", 15.fizzBuzz())
        Assert.assertEquals("FizzBuzz", 30.fizzBuzz())
        Assert.assertEquals("FizzBuzz", 45.fizzBuzz())
    }
}