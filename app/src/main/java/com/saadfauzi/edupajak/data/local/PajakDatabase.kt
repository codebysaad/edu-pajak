package com.saadfauzi.edupajak.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PajakEntity::class], version = 1, exportSchema = false)
abstract class PajakDatabase: RoomDatabase() {
    abstract fun pajakDao(): PajakDao
}