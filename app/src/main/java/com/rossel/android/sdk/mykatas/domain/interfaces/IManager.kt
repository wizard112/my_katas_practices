package com.rossel.android.sdk.mykatas.domain.interfaces

import com.rossel.android.sdk.mykatas.domain.entity.Player

interface IManager {
    fun handle(player: Player): Boolean
}