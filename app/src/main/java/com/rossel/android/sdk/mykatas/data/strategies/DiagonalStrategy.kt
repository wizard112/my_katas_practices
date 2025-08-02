package com.rossel.android.sdk.mykatas.data.strategies

import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.interfaces.IWinStrategy

class DiagonalStrategy(val grid: HashMap<Int, Player>): IWinStrategy {
    override fun isTaken(player: Player): Boolean {
        return mainDiagonal(player = player) || antiDiagonal(player = player)
    }

    private fun mainDiagonal(player: Player): Boolean {
        return (grid[1] == player
                && grid[5] == player
                && grid[9] == player)
    }

    private fun antiDiagonal(player: Player): Boolean {
        return (grid[3] == player
                && grid[5] == player
                && grid[7] == player)
    }
}
