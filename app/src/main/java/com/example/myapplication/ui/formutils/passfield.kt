package com.example.myapplication.ui.formutils

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassTextField(
    pass: String,
    onValueChange: (String) -> Unit,
    isError: Boolean?,
    onImeActionClick: () -> Unit,
    imeAction: ImeAction = ImeAction.Done
) {
    var passVisibility by remember { mutableStateOf(false) }
    TextField(
        value = pass,
        onValueChange = onValueChange,
        visualTransformation = if (passVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passVisibility = !passVisibility }) {
                Icon(
                    imageVector = if (passVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Show pass"
                )
            }
        },
        label = { Text(text = "Pass") },
        isError = isError != null,
        placeholder = { Text(text = ">5 characters pass") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions { onImeActionClick() }
    )

}