package com.example.rockpaperscissor.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rockpaperscissor.ui.aliceBlue
import com.example.rockpaperscissor.ui.grayColor
import com.example.rockpaperscissor.ui.infoColor
import com.example.rockpaperscissor.ui.secondaryTextColor

//Important
@Composable
fun ResultSection(modifier: Modifier = Modifier, title: String, result: String) {
    Surface(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(125.dp),
        shape = RoundedCornerShape(5.dp),
        color = grayColor,
        tonalElevation = 1.dp,
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier,
                text = title,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                modifier = modifier,
                text = result,
                style = MaterialTheme.typography.bodyLarge,
                color = secondaryTextColor
            )
        }
    }
}

@Composable
fun PlayerInfoText(modifier: Modifier = Modifier, text: String) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(5.dp),
        color = aliceBlue,
        tonalElevation = 1.dp,
        shadowElevation = 1.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = text,
                color = infoColor,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}


//Important
@Composable
fun TwoPlayerInfoText(playerText1: String, playerText2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PlayerInfoText(
            Modifier
                .padding(start = 16.dp, top = 0.dp, bottom = 4.dp, end = 4.dp)
                .weight(1f), text = playerText1)
        PlayerInfoText(
            Modifier
                .padding(start = 4.dp, top = 0.dp, bottom = 4.dp, end = 16.dp)
                .weight(1f), text = playerText2)
    }

}

@Composable
fun PlayerMove(modifier: Modifier = Modifier, img: Int) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(5.dp),
        color = aliceBlue,
        tonalElevation = 1.dp,
        shadowElevation = 1.dp
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            painter = painterResource(id = img),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
    }
}


//Important
@Composable
fun TwoPlayerMoves(player1Img: Int?, player2Img: Int?) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (player1Img != null) {
            PlayerMove(modifier = Modifier
                .padding(start = 16.dp, top = 4.dp, bottom = 8.dp, end = 4.dp)
                .weight(1f), img = player1Img)
        }
        if (player2Img != null) {
            PlayerMove(modifier = Modifier
                .padding(start = 4.dp, top = 4.dp, bottom = 8.dp, end = 16.dp)
                .weight(1f), img = player2Img)
        }
    }
}


//Important
@Composable
fun PlayButton(buttonText: String, replayIcon: Boolean = false, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .height(80.dp),
            onClick = onClick,
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = infoColor,
                contentColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = infoColor.copy(0.6f),
                disabledContentColor = MaterialTheme.colorScheme.surface.copy(0.6f)
            ),
            elevation = ButtonDefaults.buttonElevation(),
            contentPadding = PaddingValues(
                start = 32.dp,
                top = 16.dp,
                end = 32.dp,
                bottom = 16.dp
            )
        ) {
            Text(
                modifier = Modifier,
                text = buttonText
            )
            if (replayIcon) {
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Refresh",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}