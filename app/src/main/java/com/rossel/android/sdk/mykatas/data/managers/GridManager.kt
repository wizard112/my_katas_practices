package com.rossel.android.sdk.mykatas.data.managers

import com.rossel.android.sdk.mykatas.data.strategies.ColumnStrategy
import com.rossel.android.sdk.mykatas.data.strategies.DiagonalStrategy
import com.rossel.android.sdk.mykatas.data.strategies.RowStrategy
import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.interfaces.IManager
import com.rossel.android.sdk.mykatas.domain.interfaces.IStrategy

class GridManager(val grid: HashMap<Int, Player>): IManager {
    private val columnStrategy: IStrategy = ColumnStrategy(grid = grid)
    private val rowStrategy: IStrategy = RowStrategy(grid = grid)
    private val diagonalStrategy: IStrategy = DiagonalStrategy(grid = grid)

    override fun handle(player: Player): Boolean {
        return columnStrategy.isTaken(player = player)
                || columnStrategy.isTaken(player = player)
                || rowStrategy.isTaken(player = player)
                || rowStrategy.isTaken(player = player)
                || diagonalStrategy.isTaken(player = player)
                || diagonalStrategy.isTaken(player = player)
                || isAllTaken()
    }

    private fun isAllTaken(): Boolean {
        return grid.size == 9
    }
}