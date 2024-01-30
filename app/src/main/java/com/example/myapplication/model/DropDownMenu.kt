package com.example.myapplication.model

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.myapplication.ui.screens.home.DropDownMenuActions


@Composable
fun DropDownMenuItems(onActionClick: (DropDownMenuActions) -> Unit) {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    Box {
        TextButton(onClick = { isDropDownMenuExpanded = true }) {
            Text(text = "Share")
        }
        DropdownMenu(
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false }) {
            DropDownMenuActions.values().forEach { action ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(id = action.actionName),
                            color = if (action.destructive) Color.Red else Color.Unspecified
                        )
                    },

                    onClick = {
                        isDropDownMenuExpanded = false
                        onActionClick(action)
                    })
            }
        }
    }
}