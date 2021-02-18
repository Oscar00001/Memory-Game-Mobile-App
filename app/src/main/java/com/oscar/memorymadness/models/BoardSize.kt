package com.oscar.memorymadness.models
enum class BoardSize(val numCards:Int){
    EASY (8),
    MEDIUM(18),
    HARD(24);

    fun getWidth():Int{
        return  when (this){
            EASY -> 2
            MEDIUM -> 3
            HARD -> 4
        }
    }
    fun getHeight():Int{
        return numCards/getWidth() // do we know 2 col do fill rest in
    }
    fun getNumPairs():Int{
        return  numCards/2 // we know its half of it if i have 6 cards i have 3 right?
    }
}
