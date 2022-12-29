package com.example.a012anatomyofbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }


        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()

        return when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun rollDice() {
        diceImage1.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())

    }

    private fun reset(){
        val diceImage : ImageView = findViewById(R.id.dice_image1)

        diceImage.setImageResource(R.drawable.empty_dice)
    }
}



