package com.example.myapplication.ui.formutils

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTextField(value: String, onValueChange: (String) -> Unit, message: String?) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "User") },
        isError = message != null,
        placeholder = { Text(text = "Input user") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next)
    )
}