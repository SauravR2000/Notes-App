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

@Composable
fun Navigation(
    textFieldViewModel: TextFieldViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
        modifier = Modifier.navigationBarsPadding().statusBarsPadding()
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(textFieldViewModel = textFieldViewModel, navController)
        }
        composable(Screen.SignupScreen.route) {
            SignupScreen(textFieldViewModel = textFieldViewModel, navController)
        }
    }
}
