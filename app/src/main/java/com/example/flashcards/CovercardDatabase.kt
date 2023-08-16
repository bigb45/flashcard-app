package com.example.flashcards

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flashcards.data.Covercard

@Database(
    entities = [Covercard::class],
    version = 1
)
abstract class CovercardDatabase: RoomDatabase() {
    abstract val dao: CovercardDao
}