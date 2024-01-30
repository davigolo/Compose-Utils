package com.example.myapplication.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.model.Item
import com.example.myapplication.ui.screens.Screen

@Composable
@Preview(showBackground = true)
fun Home(homeViewModel: HomeViewModel = viewModel()) {
    //var items by remember { mutableStateOf(itemList.take(15)) }
    Home(items = homeViewModel.state, onActionClick = homeViewModel::onItemAction)
}

@Composable
fun Home(items: List<Item>, onActionClick: (DropDownMenuActions, Int) -> Unit) {
    Screen {
        HomeGrid(items = items, onActionClick = onActionClick)
    }
}