package com.rossel.android.sdk.mykatas.ui

import androidx.compose.runtime.Immutable
import com.rossel.android.sdk.mykatas.domain.enums.Symbols

@Immutable
data class TicTactToeUiState(
    var loading: Boolean = false,
    var error: String? = null,
    var symbols: List<Symbols> = emptyList()
)