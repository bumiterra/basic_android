package com.example.androiddasar

import org.junit.Assert
import org.junit.Test

class GameTest {

    @Test
    fun testPickRandomOption() {
        val options = listOf("ROCK", "PAPER", "SCISSORS")
        for (i in 1..10) {
            Assert.assertTrue(options.contains(Game.pickRandomOption()))
        }
    }

    @Test
    fun testPickDrawable() {
        Assert.assertEquals(R.drawable.rock, Game.pickDrawable("ROCK"))
        Assert.assertEquals(R.drawable.paper, Game.pickDrawable("PAPER"))
        Assert.assertEquals(R.drawable.scissors, Game.pickDrawable("SCISSORS"))
    }

    @Test
    fun testIsDraw() {
        Assert.assertTrue(Game.isDraw("ROCK", "ROCK"))
        Assert.assertFalse(Game.isDraw("ROCK", "PAPER"))
        Assert.assertFalse(Game.isDraw("ROCK", "SCISSORS"))
        Assert.assertFalse(Game.isDraw("PAPER", "ROCK"))
        Assert.assertTrue(Game.isDraw("PAPER", "PAPER"))
        Assert.assertFalse(Game.isDraw("PAPER", "SCISSORS"))
        Assert.assertFalse(Game.isDraw("SCISSORS", "ROCK"))
        Assert.assertFalse(Game.isDraw("SCISSORS", "PAPER"))
    }

    @Test
    fun testIsWin() {
        Assert.assertFalse(Game.isWin("ROCK", "PAPER"))
        Assert.assertTrue(Game.isWin("ROCK", "SCISSORS"))
        Assert.assertTrue(Game.isWin("PAPER", "ROCK"))
        Assert.assertFalse(Game.isWin("PAPER", "SCISSORS"))
        Assert.assertFalse(Game.isWin("SCISSORS", "ROCK"))
        Assert.assertTrue(Game.isWin("SCISSORS", "PAPER"))
    }

}