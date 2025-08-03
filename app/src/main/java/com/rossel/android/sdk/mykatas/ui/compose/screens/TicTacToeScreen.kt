package com.rossel.android.sdk.mykatas.ui.compose.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.ui.TicTacToeIntents
import com.rossel.android.sdk.mykatas.ui.TicTacToeViewModel


@Composable
fun TicTacToeScreen(viewModel: TicTacToeViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val playerName by viewModel.playerName.collectAsStateWithLifecycle()
    Log.d("TESTTICTACTOE"," player : $playerName")

    when {
        uiState.loading -> {}
        uiState.error != null -> {}
        uiState.symbols.isNotEmpty() -> {
            LazyVerticalGrid (columns = GridCells.Fixed(count = 3),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(top = 100.dp, start = 20.dp, end = 20.dp)) {
                items(count = uiState.symbols.size,
                    key = { it }) { position ->
                    val symbol = uiState.symbols[position]
                    GridCell(viewModel = viewModel, symbol = symbol, position = position+1)
                }
            }
        }
    }
}

@Composable
private fun GridCell(viewModel: TicTacToeViewModel, position: Int, symbol: Symbols) {
    val buttonState by viewModel.enableButton.collectAsStateWithLifecycle()
    Column(modifier = Modifier
        .size(size = 50.dp)
        .background(color = Color.White, shape = RoundedCornerShape(size = 10.dp))
        .clickable(enabled = buttonState) {
            viewModel.handleIntents(intent = TicTacToeIntents.MakeMove(position = position))
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = when(symbol) {
            Symbols.X -> Symbols.X.name
            Symbols.O -> Symbols.O.name
            Symbols.EMPTY -> ""
        },
            color = when(symbol) {
                Symbols.X -> Color.Red
                Symbols.O -> Color.Green
                Symbols.EMPTY -> Color.Yellow
            },
            fontSize = 20.sp)
    }
}