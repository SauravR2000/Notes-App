package com.example.notesapp.Auth

import TextFieldValidation
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.notesapp.Constants.screenPadding
import com.example.notesapp.Navigation.Screen
import com.example.notesapp.utils.Space10
import com.example.notesapp.utils.Space20

@Composable
fun LoginScreen(
    textFieldViewModel: TextFieldViewModel,
    navController: NavHostController,
) {


    val focusManager = LocalFocusManager.current

    //device height and width
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = screenPadding)
//            .background(
//                brush = Brush.verticalGradient(
//                    colors = listOf(
//                        Color.Black.copy(alpha = 0.1f),
//                        Color.Transparent,
//                    )
//                )
//            )

    ) {
        Box(
            modifier = Modifier
                .size(
                    height = screenHeight / 1.5f,
                    width = screenWidth / .3f
                )
                .background(Color.White),
            contentAlignment = Alignment.Center,

            ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(text = "Login", style = MaterialTheme.typography.headlineMedium)
                Space20()
                TextFieldValidation(
                    value = textFieldViewModel.emailValue,
                    placeholder = "Email",
                    onChange = textFieldViewModel::setEmail,
                    isError = textFieldViewModel.emailError.isNotEmpty(),
                    icon = Icons.Rounded.Email,
                    errorMessage = textFieldViewModel.emailError,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier

                )
                Space20()
                TextFieldValidation(
                    value = textFieldViewModel.passwordValue,
                    onChange = textFieldViewModel::setPassword,
                    placeholder = "Password",
                    isError = textFieldViewModel.passwordError.isNotEmpty(),
                    icon = Icons.Rounded.Password,
                    isPassword = true,
                    errorMessage = textFieldViewModel.passwordError,
                    modifier = Modifier

                )
                Space10()
                Text(text = "Forgot Password?", color = MaterialTheme.colorScheme.primary)
                Space10()
                Button(
                    onClick = {
                        focusManager.clearFocus()
                        if (textFieldViewModel.validateLoginForm()) {
                            navController.navigate(Screen.SignupScreen.route)
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Blue)
                ) {
                    Text(
                        text = "Login".uppercase(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = White
                    )
                }
                Space20()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Don't have an account ? ")
                    Text(text = "Signup",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.SignupScreen.route)
                        })

                }

            }
        }
    }
}