package com.rossel.android.sdk.mykatas.domain.entity


data class Player(val name: String = "")
const val PLAYER_X = "X"
const val PLAYER_O = "O"

class TicTacToe {
    private var grid = hashMapOf<Int, Player>()
    val playerX = Player(name = PLAYER_X)
    val playerO = Player(name = PLAYER_O)

    fun isGameOver(): Boolean {
        return isColumnTaken(player = playerX)
                || isColumnTaken(player = playerO)
                || isRowTaken(player = playerX)
                || isRowTaken(player = playerO)
                || isDiagonalTaken(player = playerX)
                || isDiagonalTaken(player = playerO)
                || isAllTaken()
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