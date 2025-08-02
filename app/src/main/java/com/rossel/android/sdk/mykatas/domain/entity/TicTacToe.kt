package com.rossel.android.sdk.mykatas.domain.entity

/*class Column {
    var player: String = ""
    var position: Int = -1
}
class Row {
    var player: String = ""
    var position: Int = -1
}*/

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

    private var columns = hashMapOf<Int, Player>()
    private var rows = hashMapOf<Int, Player>()
    fun isGameOver(): Boolean {
        return (columns[1]?.name == "X" &&
                (rows[1]?.name == "X" || rows[2]?.name == "X" || rows[3]?.name == "X" )
                || columns[2]?.name == "X" &&
                (rows[1]?.name == "X" || rows[2]?.name == "X" || rows[3]?.name == "X" )
                || columns[3]?.name == "X" &&
                (rows[1]?.name == "X" || rows[2]?.name == "X" || rows[3]?.name == "X" ))
    }
    fun play(column: Int, row: Int, player: Player) {
        columns[column] = player
        rows[row] = player
    }

    /*fun takesTurn() {

    }*/
}