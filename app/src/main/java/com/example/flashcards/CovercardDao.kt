package com.example.flashcards

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.flashcards.data.Covercard
import kotlinx.coroutines.flow.Flow

@Dao
interface CovercardDao {
    @Upsert
    suspend fun insertCovercard(covercard: Covercard)

    @Delete
    suspend fun deleteCovercard(covercard: Covercard)
    @Query("SELECT * FROM covercards")
    fun getCovercards(): Flow<List<Covercard>>
}