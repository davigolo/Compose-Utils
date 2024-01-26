package com.example.myapplication.ui.screens.home

import com.example.myapplication.R

enum class DropDownMenuActions(val actionName: Int, val destructive: Boolean = false) {
    SUBMIT(actionName = R.string.action_submit),
    DELETE(actionName = R.string.action_delete, destructive = true)
}