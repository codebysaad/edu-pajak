package com.saadfauzi.edupajak.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taxes")
data class PajakEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val taxesCode: Int,
    val taxesName: String,
    val taxesIcon: String,
    val desc: String,
    var isBookmarked: Boolean = false,
)