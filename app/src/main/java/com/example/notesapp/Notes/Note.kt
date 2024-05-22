package com.example.notesapp.Notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note-table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    @ColumnInfo(name = "note-title")
    val title : String = "",
    @ColumnInfo(name = "note-desc")
    val descriptor: String = ""
)

