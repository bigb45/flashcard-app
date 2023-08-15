package com.example.flashcards.data

import android.graphics.Color

data class Flashcard(
    val question: String,
    val answer: String,
    var answeredCorrectly: Boolean?,
//    val explanation: String?,
//    val Color: Color
)
