package com.example.myapplication.ui.screens.Login

import android.widget.TextView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    data class UiState(
        val userLoggedIn: Boolean = false,
        val error: String? = null
    )

    fun loginClick(user: String, pass: String) {
        state = when {
            !user.contains('@') -> UiState(error = "User must have @")
             pass.length < 5 -> UiState(error = "Pass is too short")
            else -> UiState(userLoggedIn = true)
        }
    }
}