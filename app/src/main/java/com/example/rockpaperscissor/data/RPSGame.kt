package com.example.rockpaperscissor.data

import kotlin.random.Random

class Person(val name: String) {

    fun makeMove(): String? {

        val moves: Map<Int, String> = mapOf(0 to "Rock", 1 to "Paper", 2 to "Scissor")
        val randomNum = Random.nextInt(0, 3)

        return moves[randomNum]
    }

}