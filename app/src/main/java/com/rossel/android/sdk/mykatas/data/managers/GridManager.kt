package com.rossel.android.sdk.mykatas.data.managers

import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.interfaces.IManager

class GridManager(val grid: HashMap<Int, Player>): IManager {

    override fun handle(player: Player): Boolean {
        return isColumnTaken(player = player)
                || isColumnTaken(player = player)
                || isRowTaken(player = player)
                || isRowTaken(player = player)
                || isDiagonalTaken(player = player)
                || isDiagonalTaken(player = player)
                || isAllTaken()
    }

    private fun isColumnTaken(player: Player): Boolean{
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

    private fun isRowTaken(player: Player): Boolean{
        return ((grid[1] == player
                && grid[2] == player
                && grid[3] == player)
                || (grid[4] == player
                && grid[5] == player
                && grid[6] == player)
                || (grid[7] == player
                && grid[8] == player
                && grid[9] == player)
                )
    }

    private fun isDiagonalTaken(player: Player): Boolean {
        return ((grid[1] == player
                && grid[5] == player
                && grid[9] == player)
                || (grid[3] == player
                && grid[5] == player
                && grid[7] == player)
                )
    }

    private fun isAllTaken(): Boolean {
        return grid.size == 9
    }
}