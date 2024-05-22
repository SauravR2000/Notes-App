package com.example.notesapp.Navigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.Auth.LoginScreen
import com.example.notesapp.Auth.SignupScreen
import com.example.notesapp.Auth.TextFieldViewModel
import com.example.notesapp.Notes.Presentation.NotesScreen

@Composable
fun Navigation(
    loginTextFieldViewModel: TextFieldViewModel = TextFieldViewModel(),
    signupTextFieldViewModel: TextFieldViewModel = TextFieldViewModel(),
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
        modifier = Modifier
            .navigationBarsPadding()
            .statusBarsPadding()
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(textFieldViewModel = loginTextFieldViewModel, navController)
        }
        composable(Screen.SignupScreen.route) {
            SignupScreen(textFieldViewModel = signupTextFieldViewModel, navController)
        }
//        composable(Screen.NotesScreen.route) {
//            NotesScreen(textFieldViewModel = signupTextFieldViewModel, navController)
//        }
    }
}
