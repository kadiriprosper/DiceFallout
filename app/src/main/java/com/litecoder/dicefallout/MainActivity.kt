package com.litecoder.dicefallout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/*
 A simple game that matches the users random dice roll against the computers'
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // call the rollDice function when the referenced button is clicked
            rollDice()
        }
        rollDice()
    }

    // a function to roll a dice and set the image property of the dice
    private fun rollDice(){
        // create a dice object with 6 sides
        val dice: Dice = Dice(6)

        // call the roll method on the dice object
        val diceRoll1 = dice.roll()
        val diceRoll2 = dice.roll()

        // set the images to according to the random number generated
        val drawableResource = when(diceRoll1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when(diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //reference the imageView object
        val image1: ImageView = findViewById(R.id.imageView)
        val image2: ImageView = findViewById(R.id.imageView2)

        // set the images on the imageView
        image1.setImageResource(drawableResource)
        image1.contentDescription = diceRoll1.toString()
        image2.setImageResource(drawableResource2)
        image2.contentDescription = diceRoll2.toString()

        // reference the textView object
        val textHolder = findViewById<TextView>(R.id.textView2)

        // set the textView text according to the conditions
        textHolder.text = if(diceRoll1 > diceRoll2) {"USER WON"}
        else if(diceRoll2 > diceRoll1) { "COMPUTER WON" }
        else "DRAW"

    }
}