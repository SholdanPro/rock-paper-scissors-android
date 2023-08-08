package com.example.rockpaperscissor.ui

import androidx.lifecycle.ViewModel
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.data.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class RPSUiState(
    val title: String = "Welcome!",
    val result: String = "Rock, Paper & Scissor",
    val playerImg1: Int? = R.drawable.glass_smile,
    val playerImg2: Int? = R.drawable.smile_emoji,
    val playerMove1: String = "Let's make",
    val playerMove2: String = "a move."
)

class RPSViewModel : ViewModel() {

    //State
    private val _uiState = MutableStateFlow(RPSUiState())
    val uiState: StateFlow<RPSUiState> = _uiState.asStateFlow()

    //Data
    val playerEmoji1 = R.drawable.glass_smile
    val playerEmoji2 = R.drawable.smile_emoji
    val rock = R.drawable.rock
    val paper = R.drawable.paper
    val scissor = R.drawable.scissor

    //Objects
    private val player1 = Person("John")
    private val player2 = Person("Eda")

    fun play() {
        _uiState.update { currentState ->

            val RPS: Map<String, Int> = mapOf("Rock" to rock, "Paper" to paper, "Scissor" to scissor)
            val playerGuess: MutableList<String> = mutableListOf()

            player1.makeMove()?.let { playerGuess.add(it) }
            player2.makeMove()?.let { playerGuess.add(it) }

            //Move Data for state
            val playerGuessed: List<String> = playerGuess
            val p1 = playerGuessed[0]
            val p2 = playerGuessed[1]

            //Result for State
            val title: String
            val result: String

            if (p1 == "Rock" && p2 == "Paper") {
                title = "Congratulation!"
                result = "${player2.name} Won!"
            } else if(p1 == "Rock" && p2 == "Scissor") {
                title = "Congratulation!"
                result = "${player1.name} Won!"
            } else if(p1 == "Paper" && p2 == "Rock") {
                title = "Congratulation!"
                result = "${player1.name} Won!"
            } else if(p1 == "Paper" && p2 == "Scissor") {
                title = "Congratulation!"
                result = "${player2.name} Won!"
            } else if (p1 == "Scissor" &&  p2 == "Rock") {
                title = "Congratulation!"
                result = "${player2.name} Won!"
            } else if (p1 == "Scissor" && p2 == "Paper") {
                title = "Congratulation!"
                result = "${player1.name} Won!"
            } else {
                title = "DRAW!"
                result = "Play again it's draw!"
            }

            currentState.copy(
                title = title,
                result = result,
                playerImg1 = RPS[p1],
                playerImg2 = RPS[p2],
                playerMove1 = p1,
                playerMove2 = p2
            )
        }
    }

}