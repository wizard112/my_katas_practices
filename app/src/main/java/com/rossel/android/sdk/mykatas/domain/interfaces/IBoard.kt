package com.rossel.android.sdk.mykatas.domain.interfaces

import com.rossel.android.sdk.mykatas.domain.entity.Player

interface IBoard {
    fun takeField(position: Int, player: Player)
    fun isFinished(player: Player): Boolean
    fun giveMeBoard(): Map<Int, Player>
}