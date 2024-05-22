package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.notesapp.Auth.LoginScreen
import com.example.notesapp.Auth.TextFieldViewModel
import com.example.notesapp.Navigation.Navigation

import com.example.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: TextFieldViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
//                LoginScreen(viewModel)
                Navigation()
            }

        }
    }
}

