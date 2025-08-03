package com.rossel.android.sdk.mykatas.data.managers

import android.util.Log
import com.rossel.android.sdk.mykatas.data.strategies.ColumnStrategy
import com.rossel.android.sdk.mykatas.data.strategies.DiagonalStrategy
import com.rossel.android.sdk.mykatas.data.strategies.RowStrategy
import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.domain.interfaces.IChecker
import com.rossel.android.sdk.mykatas.domain.interfaces.IWinStrategy

class WinnerChecker(val grid: HashMap<Int, Player>):
    IChecker {
    private val strategies: MutableList<IWinStrategy> = mutableListOf(
        ColumnStrategy(grid = grid),
        RowStrategy(board = grid),
        DiagonalStrategy(grid = grid)
    )

    override fun hasPlayerWon(player: Player): Boolean {
        val result = strategies.any { winStrategy -> winStrategy.isTaken(player = player) }
        Log.d("TESTTICTACTOE","result is $result & ${isAllTaken()}")
        return result || isAllTaken()
    }

    private fun isAllTaken(): Boolean {
        return grid.values.filter { player -> player.symbol != Symbols.EMPTY }.size == 9
    }
}