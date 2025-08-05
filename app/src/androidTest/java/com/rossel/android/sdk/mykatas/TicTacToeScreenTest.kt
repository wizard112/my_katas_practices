package com.rossel.android.sdk.mykatas

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rossel.android.sdk.mykatas.ui.TicTacToeIntents
import com.rossel.android.sdk.mykatas.ui.TicTacToeViewModel
import com.rossel.android.sdk.mykatas.ui.compose.screens.TicTacToeScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class TicTacToeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: TicTacToeViewModel

    @Before
    fun setUp() {
        viewModel = TicTacToeViewModel()
    }

    @Test
    fun testPlayerNameAndBoardAppear() = runTest {
        // Trigger start intent manually
        viewModel.handleIntents(TicTacToeIntents.Start)

        composeTestRule.setContent {
            TicTacToeScreen(viewModel = viewModel)
        }

        // Check player name is shown
        composeTestRule
            .onNodeWithTag("PlayerName")
            .assertIsDisplayed()

        // Check board is displayed
        composeTestRule
            .onNodeWithTag("GameBoard")
            .assertIsDisplayed()

        // Check first cell is clickable
        composeTestRule
            .onNodeWithTag("Cell_1")
            .assertHasClickAction()
    }
}