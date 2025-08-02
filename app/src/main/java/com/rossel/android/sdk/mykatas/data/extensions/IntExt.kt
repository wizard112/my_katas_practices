package com.rossel.android.sdk.mykatas.data.extensions

fun Int.fizzBuzz(): String {
    return when {
        this %3 == 0 && this %5 == 0 -> "FizzBuzz"
        this %3 == 0 -> "Fizz"
        else -> "Buzz"
    }
}