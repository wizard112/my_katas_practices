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

    fun isGameOver(column: Int): Boolean = true

    /*fun takesTurn() {

    }*/
}