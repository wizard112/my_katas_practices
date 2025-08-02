package com.rossel.android.sdk.mykatas.domain.interfaces

import com.rossel.android.sdk.mykatas.domain.entity.Player

interface IChecker {
    fun hasPlayerWon(player: Player): Boolean
}