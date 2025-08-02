package com.rossel.android.sdk.mykatas.domain.entity

import com.rossel.android.sdk.mykatas.data.game.Board
import com.rossel.android.sdk.mykatas.data.game.Engine
import com.rossel.android.sdk.mykatas.domain.interfaces.IBoard
import com.rossel.android.sdk.mykatas.domain.interfaces.IEngine

class Game {
    private val engine: IEngine = Engine()
    private val board: IBoard = Board()
    var isOver: Boolean = false

    fun play(position: Int) {
        val player = engine.turnTo()
        board.takeField(position = position, player = player)
        isOver = board.isFinished(player = player)
    }
}