package com.rossel.android.sdk.mykatas.domain.entity


data class Player(val name: String = "")

class TicTacToe {
    private var grid = hashMapOf<Int, Player>()
    val playerX = Player(name = "X")
    val playerO = Player(name = "0")
    fun isGameOver(): Boolean {
        return isColumnTaken(player = playerX)
                || isColumnTaken(player = playerO)
                || isRowTaken(player = playerX)
                || isRowTaken(player = playerO)
    }
    fun play(position: Int, player: Player) {
        grid[position] = player
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

}