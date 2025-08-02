package com.rossel.android.sdk.mykatas.ui.compose.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rossel.android.sdk.mykatas.domain.enums.Symbols
import com.rossel.android.sdk.mykatas.ui.TicTacToeIntents
import com.rossel.android.sdk.mykatas.ui.TicTacToeViewModel


@Composable
fun TicTacToeScreen(viewModel: TicTacToeViewModel) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    when {
        uiState.value.loading -> {}
        uiState.value.error != null -> {}
        uiState.value.board -> {
            LazyVerticalGrid (columns = GridCells.Fixed(count = 3),
                modifier = Modifier
                    .padding(top = 100.dp)
                    .fillMaxWidth()) {
                viewModel.mutableBoard.forEach { item ->
                    Log.d("TESTTICTACTOE","from list ${item.name} ***")
                }
                items(count = viewModel.mutableBoard.size,
                    key = { it }) { position ->
                    val symbol = viewModel.mutableBoard[position]
                    Log.d("TESTTICTACTOE","item is ${symbol.name} ***")
                    Column(modifier = Modifier
                        .size(size = 40.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(size = 10.dp))
                        .clickable {
                            Log.d("TESTTICTACTOE","click ${symbol.name}")
                            viewModel.handleIntents(intent = TicTacToeIntents.Play(position = position))
                        }) {
                        Text(text = when(symbol) {
                            Symbols.X -> Symbols.X.name
                            Symbols.O -> Symbols.O.name
                            Symbols.EMPTY -> ""
                        },
                            color = when(symbol) {
                                Symbols.X -> Color.Red
                                Symbols.O -> Color.Green
                                Symbols.EMPTY -> Color.Yellow
                            })
                    }
                }
            }
        }
    }
}