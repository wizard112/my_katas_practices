package com.rossel.android.sdk.mykatas.data.game

import com.rossel.android.sdk.mykatas.data.exception.TicTacToeException
import com.rossel.android.sdk.mykatas.data.managers.WinnerChecker
import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.interfaces.IBoard
import com.rossel.android.sdk.mykatas.domain.interfaces.IChecker

class Board: IBoard {
    private var grid = hashMapOf<Int, Player>()
    var board: IChecker = WinnerChecker(grid = grid)

    override fun takeField(position: Int, player: Player) {
        if (grid[position] != null)
            throw TicTacToeException(msg = "The field is already taken ")
        grid[position] = player
    }

    override fun isFinished(player: Player): Boolean {
        return board.hasPlayerWon(player = player)
    }
}