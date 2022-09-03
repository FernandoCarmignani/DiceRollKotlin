package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
/*
Makes it possible to roll a dice and see the output
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }
/*
Rolls the dice and updates the textview
 */
    private fun rollDice() {
    //creates an object from Dice to have 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()
    //creates a second dice from dice to have 20 sides
        val dice1 = Dice(20)
        val diceR = dice1.roll()
    //Update de dice image to the roll
    val diceImage: ImageView = findViewById(R.id.imageView)
    val drawableR = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    diceImage.setImageResource(drawableR)
    diceImage.contentDescription = diceRoll.toString()

}
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}