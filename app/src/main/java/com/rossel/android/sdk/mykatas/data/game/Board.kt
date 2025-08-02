package com.rossel.android.sdk.mykatas.data.game

import com.rossel.android.sdk.mykatas.data.exception.TicTacToeException
import com.rossel.android.sdk.mykatas.data.managers.WinnerChecker
import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.domain.interfaces.IBoard
import com.rossel.android.sdk.mykatas.domain.interfaces.IChecker

class Board: IBoard {
    var grid = hashMapOf<Int, Player>()
    var board: IChecker = WinnerChecker(grid = grid)
    init {
        grid[1] = Player(symbol = Symbols.EMPTY)
        grid[2] = Player(symbol = Symbols.EMPTY)
        grid[3] = Player(symbol = Symbols.EMPTY)
        grid[4] = Player(symbol = Symbols.EMPTY)
        grid[5] = Player(symbol = Symbols.EMPTY)
        grid[6] = Player(symbol = Symbols.EMPTY)
        grid[7] = Player(symbol = Symbols.EMPTY)
        grid[8] = Player(symbol = Symbols.EMPTY)
        grid[9] = Player(symbol = Symbols.EMPTY)
    }

    override fun takeField(position: Int, player: Player) {
        if (grid[position] != null && grid[position]?.symbol != Symbols.EMPTY)
            throw TicTacToeException(msg = "The field is already taken ")
        grid[position] = player
    }

    override fun isFinished(player: Player): Boolean {
        return board.hasPlayerWon(player = player)
    }

    override fun giveMeBoard(): Map<Int, Player> = grid
}