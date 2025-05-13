package com.example.androiddasar

import kotlin.random.Random

object Game {
    private val options = listOf("ROCK", "PAPER", "SCISSORS")
    private val optionDrawables = mapOf(
        "ROCK" to R.drawable.rock,
        "PAPER" to R.drawable.paper,
        "SCISSORS" to R.drawable.scissors,
    )
    private val rules = mapOf(
        "ROCK-PAPER" to false,
        "ROCK-SCISSORS" to true,
        "PAPER-ROCK" to true,
        "PAPER-SCISSORS" to false,
        "SCISSORS-ROCK" to false,
        "SCISSORS-PAPER" to true,
    )

    fun pickRandomOption(): String = options[Random.nextInt(0, 3)]
    fun pickDrawable(option: String): Int = optionDrawables[option]!!
    fun isDraw(from: String, to: String): Boolean = from == to
    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!
}
