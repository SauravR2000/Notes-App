package com.example.notesapp

import android.content.Context
import androidx.room.Room
import com.example.notesapp.Database.NoteDatabse
import com.example.notesapp.Notes.NoteRepository

object  Graph {
    private  lateinit var database : NoteDatabse

    val noteRepository by lazy {
        NoteRepository(notesDao = database.noteDao())
    }

    fun provide(context : Context) {
        val dbName = "notes.db"

        database = Room.databaseBuilder(
            context = context,
            klass = NoteDatabse::class.java,
            name = dbName,
        ).build()
    }
}