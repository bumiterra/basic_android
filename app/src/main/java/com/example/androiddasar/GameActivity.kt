package com.example.androiddasar

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity: AppCompatActivity() {

    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListeners() {
        rockImageButton.setOnClickListener { startGame("ROCK") }
        paperImageButton.setOnClickListener { startGame("PAPER") }
        scissorsImageButton.setOnClickListener { startGame("SCISSORS") }
    }

    private fun startGame(playerOption: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))
        when {
            Game.isDraw(playerOption, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(playerOption, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

}
