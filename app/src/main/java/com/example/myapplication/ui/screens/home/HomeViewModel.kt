package com.example.myapplication.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.itemList

class HomeViewModel : ViewModel() {

    var state by mutableStateOf(itemList)
        private set

    fun onItemAction(action: DropDownMenuActions, index: Int) {

        state = state.toMutableList().apply {
            when (action) {
                DropDownMenuActions.SUBMIT -> add(index, get(index))
                DropDownMenuActions.DELETE -> removeAt(index)
            }
        }

    }
}