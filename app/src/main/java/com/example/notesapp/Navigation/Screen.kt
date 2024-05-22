package com.example.notesapp.Navigation

sealed class Screen(var route: String) {
    object LoginScreen : Screen("login_screen")
    object SignupScreen : Screen("signup_screen")

    object NotesScreen : Screen("notes_screen")
}