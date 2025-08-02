package com.rossel.android.sdk.mykatas.data.strategies

import com.rossel.android.sdk.mykatas.domain.entity.Player
import com.rossel.android.sdk.mykatas.domain.interfaces.IWinStrategy

class RowStrategy(val board: HashMap<Int, Player>): IWinStrategy {
    override fun isTaken(player: Player): Boolean {
        return ((board[1] == player
                && board[2] == player
                && board[3] == player)
                || (board[4] == player
                && board[5] == player
                && board[6] == player)
                || (board[7] == player
                && board[8] == player
                && board[9] == player)
                )
    }
}