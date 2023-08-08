package com.example.rockpaperscissor.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.ui.components.PlayButton
import com.example.rockpaperscissor.ui.components.ResultSection
import com.example.rockpaperscissor.ui.components.TwoPlayerInfoText
import com.example.rockpaperscissor.ui.components.TwoPlayerMoves
import androidx.lifecycle.viewmodel.compose.viewModel

val grayColor = Color(0xFFF7F7F7)
val secondaryTextColor = Color(0xFFAFAFAF)
val aliceBlue = Color(0xFFF2F7FE)
val infoColor = Color(0xFF17A2B8)



@Composable
fun MainScreen(
    viewModel: RPSViewModel = viewModel()
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()
    var refreshState by rememberSaveable{
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ResultSection(title = state.title, result = state.result)
        TwoPlayerInfoText(playerText1 = "John", playerText2 = "Eda")//Static
        TwoPlayerMoves(player1Img = state.playerImg1, player2Img = state.playerImg2)
        TwoPlayerInfoText(playerText1 = state.playerMove1, playerText2 = state.playerMove2)
        PlayButton(buttonText = "PLAY", replayIcon = refreshState) {
            viewModel.play()
            refreshState = true
        }
    }

}

