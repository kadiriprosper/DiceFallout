package com.litecoder.dicefallout

class Dice (private val sides:Int){
    fun roll(): Int = (1..sides).random()
}