package com.example.flashcards

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

object DatabaseSingleton{
    private var database: CovercardDatabase? = null
    fun getDatabase(context: Context): CovercardDatabase{
        if(database == null){
            database = Room.databaseBuilder(context, CovercardDatabase::class.java, "my-database")
                    .build()
            }
        return database!!

    }
}