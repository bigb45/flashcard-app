package com.example.flashcards.data

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "covercards")
data class Covercard(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val subtitle: String,
    val count: Int,
//    val flashcards: MutableList<Flashcard>
)