package com.rossel.android.sdk.mykatas.data.extensions

fun Int.fizzBuzz(): String {
    return if (this %3 == 0)
        "Fizz"
    else "Buzz"
}