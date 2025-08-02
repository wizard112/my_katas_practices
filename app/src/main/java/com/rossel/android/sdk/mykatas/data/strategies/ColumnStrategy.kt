package com.rossel.android.sdk.mykatas.data.strategies

import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.interfaces.IWinStrategy

class ColumnStrategy(val grid: HashMap<Int, Player>): IWinStrategy {
    override fun isTaken(player: Player): Boolean {
        return ((grid[1] == player
                && grid[4] == player
                && grid[7] == player)
                || (grid[2] == player
                && grid[5] == player
                && grid[8] == player)
                || (grid[3] == player
                && grid[6] == player
                && grid[9] == player)
                )
    }
}