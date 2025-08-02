package com.rossel.android.sdk.mykatas.domain.interfaces

import com.rossel.android.sdk.mykatas.domain.entity.Player

interface IStrategy {
    fun isTaken(player: Player): Boolean
}