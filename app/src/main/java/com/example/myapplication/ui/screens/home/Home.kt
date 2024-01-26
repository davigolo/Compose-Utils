package com.example.myapplication.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.model.itemList

@Composable
@Preview(showBackground = true)
fun Home(homeViewModel: HomeViewModel = viewModel()) {
    var items by remember { mutableStateOf(itemList.take(15)) }
    LazyColumn(
    ) {
        itemsIndexed(homeViewModel.state) { index, item ->
            Divider()
            CustomListItem(item = item, onMenuActionClick = { homeViewModel.onItemAction(it, index)})
        }
    }
}
