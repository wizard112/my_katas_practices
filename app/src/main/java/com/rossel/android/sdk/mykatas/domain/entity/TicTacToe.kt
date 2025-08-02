package com.rossel.android.sdk.mykatas.domain.entity

import com.rossel.android.sdk.mykatas.data.managers.WinnerChecker
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.domain.interfaces.IChecker


class Game {
    private var grid = hashMapOf<Int, Player>()
    private var board: IChecker = WinnerChecker(grid = grid)
    val playerOne = Player(symbol = Symbols.X)
    val playerTwo = Player(symbol = Symbols.O)

    fun play(position: Int, player: Player): Boolean {
        grid[position] = player
        return board.hasPlayerWon(player = playerOne) || board.hasPlayerWon(player = playerTwo)
    }
}