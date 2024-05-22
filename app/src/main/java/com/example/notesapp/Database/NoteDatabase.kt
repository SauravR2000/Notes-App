package com.example.notesapp.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.Notes.Note
import com.example.notesapp.Notes.NotesDao

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)

abstract class NoteDatabse : RoomDatabase() {
    abstract fun noteDao(): NotesDao
}