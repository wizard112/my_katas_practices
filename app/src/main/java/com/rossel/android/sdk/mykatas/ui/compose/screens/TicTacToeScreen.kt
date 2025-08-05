package com.rossel.android.sdk.mykatas.ui.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.ui.TicTacToeIntents
import com.rossel.android.sdk.mykatas.ui.TicTacToeState
import com.rossel.android.sdk.mykatas.ui.TicTacToeViewModel

const val REF_PLAYER = "player"
const val REF_BOARD = "board"

@Composable
fun TicTacToeScreen(viewModel: TicTacToeViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when(uiState) {
        is TicTacToeState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text("Loading Board ...", color = Color.Yellow)
            }
        }
        is TicTacToeState.Symbols -> {
            val state = uiState as TicTacToeState.Symbols
            ConstraintLayout(
                modifier = Modifier.fillMaxSize(),
                constraintSet = giveMeConstraintSet()
            ) {

                Text(state.name,
                    color = Color.Yellow,
                    modifier = Modifier
                        .layoutId(layoutId = REF_PLAYER)
                        .testTag("PlayerName"))

                LazyVerticalGrid (columns = GridCells.Fixed(count = 3),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .padding(top = 100.dp, start = 20.dp, end = 20.dp)
                        .layoutId(layoutId = REF_BOARD)
                        .testTag("GameBoard")) {
                        items(count = state.symbols.size,
                            key = { it }) { position ->
                            val symbol = state.symbols[position]
                            GridCell(viewModel = viewModel, symbol = symbol, position = position+1, enableState = state.enable)
                        }
                }
            }
        }
    }
}

private fun giveMeConstraintSet(): ConstraintSet = ConstraintSet {
    val boardRef = createRefFor(id = REF_BOARD)
    val playerRef = createRefFor(id = REF_PLAYER)

    constrain(ref = playerRef) {
        bottom.linkTo(anchor = parent.bottom, margin = 70.dp)
        start.linkTo(anchor = parent.start)
        end.linkTo(anchor = parent.end)
    }
    constrain(ref = boardRef) {
        top.linkTo(anchor = parent.top)
        bottom.linkTo(anchor = playerRef.top)
        start.linkTo(anchor = parent.start)
        end.linkTo(anchor = parent.end)
    }
}

@Composable
private fun GridCell(viewModel: TicTacToeViewModel, position: Int, symbol: Symbols, enableState: Boolean) {
    Column(modifier = Modifier
        .size(size = 50.dp)
        .background(color = Color.White, shape = RoundedCornerShape(size = 10.dp))
        .clickable(enabled = enableState) {
            viewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = position))
        }
        .testTag("Cell_$position"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = when(symbol) {
            Symbols.X -> Symbols.X.name
            Symbols.O -> Symbols.O.name
            Symbols.EMPTY -> ""
        },
            color = when(symbol) {
                Symbols.X, Symbols.O -> Color.Black
                Symbols.EMPTY -> Color.White
            },
            fontSize = 20.sp,
            modifier = Modifier.testTag("Symbol_$position"))
    }
}