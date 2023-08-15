package com.example.flashcards.data

import android.graphics.Color

data class Covercard(
    val title: String,
    val subtitle: String,
    val count: Int,
    val flashcards: MutableList<Flashcard>
)