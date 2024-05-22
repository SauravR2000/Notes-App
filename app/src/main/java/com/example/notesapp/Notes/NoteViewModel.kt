package com.example.notesapp.Notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

class NotesViewModel(
    private val noteRepository: NoteRepository = Graph.noteRepository
) : ViewModel() {
    var noteTitleState by mutableStateOf("")
    var noteDescriptionState by mutableStateOf("")

    fun onNoteTitleChange(newTitle: String) {
        noteTitleState = newTitle
    }

    fun onNoteDescriptionChange(newDescription: String) {
        noteDescriptionState = newDescription
    }

    lateinit var getAllNotes: Flow<List<Note>>

    init {
        viewModelScope.launch {
            getAllNotes = noteRepository.getAllNotes()
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.addNote(note)
        }
    }

    fun getNoteById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getNoteById(id)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteNote(note)
        }
    }


}