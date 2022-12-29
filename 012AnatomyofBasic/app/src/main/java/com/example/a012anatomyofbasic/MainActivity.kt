package com.example.a012anatomyofbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.countUp_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }



    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        resultText.text = randomInt.toString()

//        resultText.text = "Dice Rolled!"
    }

    private fun countUp(){
        val resultText: TextView = findViewById(R.id.result_text)

        if(resultText.text == "Hello World!") {
            resultText.text = "1"
        }else{
            var resultNum = resultText.text.toString().toInt()

            if(resultNum < 6)
                resultNum++
            resultText.text = resultNum.toString()

        }
    }

    private fun reset(){
        val resultText: TextView = findViewById(R.id.result_text)

        resultText.text = "0"
    }
}



