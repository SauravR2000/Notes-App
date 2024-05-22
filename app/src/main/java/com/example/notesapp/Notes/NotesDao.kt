package com.example.notesapp.Notes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addNote(note: Note)

    @Query("SELECT * FROM `note-table`")
    abstract fun getAllNotes(): Flow<List<Note>>

    @Update
    abstract fun updateNote(noteEntity: Note)

    @Delete
    abstract fun deleteNote(noteEntity: Note)

    @Query("SELECT * FROM `note-table` WHERE id = :id")
    abstract fun getNoteById(id: Long): Flow<Note>
}