package com.example.flashcards

import com.example.flashcards.data.Covercard
import com.example.flashcards.data.Flashcard

data class FlashcardsState(
    val flashcards: MutableList<Flashcard> = mutableListOf(),
    val covercards: MutableList<Covercard> = mutableListOf(),
    val isAddingFlashCards: Boolean = false,
    val isEditingFlashcards: Boolean = false,
    val isViewingFlashcards: Boolean = false

    )