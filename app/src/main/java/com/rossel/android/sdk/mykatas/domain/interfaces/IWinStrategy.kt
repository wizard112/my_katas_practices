package com.rossel.android.sdk.mykatas.domain.interfaces

import com.rossel.android.sdk.mykatas.domain.entity.Player

interface IWinStrategy {
    fun isTaken(player: Player): Boolean
}