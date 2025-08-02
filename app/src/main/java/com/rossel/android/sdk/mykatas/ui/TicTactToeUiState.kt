package com.rossel.android.sdk.mykatas.ui

import androidx.compose.runtime.Immutable

@Immutable
data class TicTactToeUiState(
    var loading: Boolean = false,
    var board: Boolean = false,
    var error: String? = null
)