package com.rossel.android.sdk.mykatas.domain.interfaces

import com.rossel.android.sdk.mykatas.domain.entity.Player

interface IEngine {
    fun turnTo(): Player
    fun nexTurnFor(): Player
}