package com.rossel.android.sdk.mykatas.data.game

import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.domain.interfaces.IEngine

class Engine: IEngine {
    private val playerOne = Player(symbol = Symbols.X)
    private val playerTwo = Player(symbol = Symbols.O)
    private var current: Player = playerOne

    override fun turnTo(): Player {
        current = nexTurnFor()
        return current
    }

    override fun nexTurnFor(): Player {
        return if (current == playerOne) playerTwo else playerOne
    }
}