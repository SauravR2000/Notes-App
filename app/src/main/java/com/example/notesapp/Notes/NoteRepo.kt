package com.example.notesapp.Notes

import kotlinx.coroutines.flow.Flow

class NoteRepository(private val notesDao: NotesDao) {
    suspend fun addNote(note: Note) {
        notesDao.addNote(note)
    }

    fun getAllNotes(): Flow<List<Note>> {
        return notesDao.getAllNotes()
    }

    fun getNoteById(id: Long): Flow<Note> {
        return notesDao.getNoteById(id)
    }

    suspend fun updateNote(note: Note) {
        notesDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }
}