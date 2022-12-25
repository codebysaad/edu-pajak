package com.saadfauzi.edupajak.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PajakDao {
    @Query("SELECT * FROM taxes")
    fun getAllTaxes(): Flow<List<PajakEntity>>

    @Query("SELECT * FROM taxes WHERE isBookmarked = 1")
    fun getAllBookmarkedTaxes(): Flow<List<PajakEntity>>

    @Query("SELECT * FROM taxes WHERE id = :id")
    fun getTaxes(id: Int): Flow<PajakEntity>

    @Query("SELECT * FROM taxes WHERE taxesName LIKE '%' || :query || '%'")
    fun searchTaxes(query: String): Flow<List<PajakEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTaxes(tourismList: List<PajakEntity>)

    @Query("UPDATE taxes SET isBookmarked = :isBookmarked WHERE id = :id")
    suspend fun updateBookmarkedTaxes(id: Int, isBookmarked: Boolean)
}