package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Screen(screen: @Composable () -> Unit) {
    MyApplicationTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            content = screen,
            modifier = Modifier.fillMaxSize()
        )
    }
}