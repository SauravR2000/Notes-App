package com.example.notesapp.Auth

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TextFieldViewModel : ViewModel() {
    var emailValue by mutableStateOf("")
        private set
    var emailError by mutableStateOf("")
        private set

    fun setEmail(value: String) {
        emailValue = value
    }

    var passwordValue by mutableStateOf("")
        private set
    var passwordError by mutableStateOf("")
        private set

    fun setPassword(value: String) {
        passwordValue = value
    }

    var userNameValue by mutableStateOf("")
        private set
    var userNameError by mutableStateOf("")
        private set

    fun setUserName(value: String) {
        userNameValue = value
    }

    private fun validateEmail(): Boolean {
        val email = emailValue.trim()
        var isValid = true
        var errorMessage = ""
        if (email.isBlank() || email.isEmpty()) {
            errorMessage = "Please fill email field"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorMessage = "Wrong email Format"
            isValid = false
        }
        emailError = errorMessage
        return isValid
    }

    private fun validatePassword(): Boolean {
        val password = passwordValue.trim()
        var isValid = true
        var errorMessage = ""

        if (password.isBlank() || password.isEmpty()) {
            errorMessage = "Please fill password field"
            isValid = false
        } else if (password.length < 6) {
            errorMessage = "Password must more than 6 character"
            isValid = false
        }
        passwordError = errorMessage
        return isValid
    }

    private fun validateUserName(): Boolean {
        val userName = userNameValue.trim()
        var isValid = true
        var errorMessage = ""

        if (userName.isBlank() || userName.isEmpty()) {
            errorMessage = "Please fill user name field"
            isValid = false
        }

        return isValid
    }

    fun validateLoginForm(): Boolean {
        if (validateEmail() && validatePassword()) {
            return true
        } else {
            return false
        }
    }

    fun validateSignupForm(): Boolean {
        if (validateEmail() && validatePassword() && validateUserName()) {
            return true
        } else {
            return false
        }
    }
}