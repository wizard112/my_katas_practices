package com.rossel.android.sdk.mykatas

import org.junit.Assert
import org.junit.Test

class FizzBuzzTest {
    @Test
    fun `prints fizz instead of the number if the number is a multiple of three`() {
        Assert.assertEquals("Fizz", fizzbuzz())
    }
}