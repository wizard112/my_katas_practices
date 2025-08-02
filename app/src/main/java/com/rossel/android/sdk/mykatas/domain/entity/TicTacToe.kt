package com.rossel.android.sdk.mykatas.domain.entity

import com.rossel.android.sdk.mykatas.data.managers.GridManager
import com.rossel.android.sdk.mykatas.domain.interfaces.IManager


class Game {
    private var grid = hashMapOf<Int, Player>()
    private var board: IManager = GridManager(grid = grid)
    val playerOne = Player(name = PLAYER_X)
    val playerTwo = Player(name = PLAYER_O)

    fun play(position: Int, player: Player): Boolean {
        grid[position] = player
        return board.handle(player = playerOne) || board.handle(player = playerTwo)
    }
}