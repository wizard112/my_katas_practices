package com.rossel.android.sdk.mykatas.domain.entity

class Column {
    var player: String = ""
    var position: Int = -1
}
class Row {
    var player: String = ""
    var position: Int = -1
}
data class Player(var name: String = "")

class TicTacToe {
    //private var columns: MutableList<Column> = mutableListOf()
    //private var rows: MutableList<Row> = mutableListOf()
    //private var players: MutableList<Player> = mutableListOf()
    //private var player: Player

    /*init {
        players.add(element = Player(name = "X"))
        players.add(element = Player(name = "O"))
    }*/

    private var columns = hashMapOf<Int, Boolean>()
    private var rows = hashMapOf<Int, Boolean>()
    fun isGameOver(): Boolean {
        return (columns.values.filter { it }.size == 3 || rows.values.filter { it }.size == 3)
    }
    fun play(column: Int, row: Int, player: String) {
        columns[column] = true
        rows[row] = true
    }

    /*fun takesTurn() {

    }*/
}