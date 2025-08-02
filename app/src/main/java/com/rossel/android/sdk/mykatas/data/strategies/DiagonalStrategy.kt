package com.rossel.android.sdk.mykatas.data.strategies

import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.interfaces.IStrategy

class DiagonalStrategy(val grid: HashMap<Int, Player>): IStrategy {
    override fun isTaken(player: Player): Boolean {
        return ((grid[1] == player
                && grid[5] == player
                && grid[9] == player)
                || (grid[3] == player
                && grid[5] == player
                && grid[7] == player)
                )
    }
}