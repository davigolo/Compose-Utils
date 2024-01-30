package com.example.myapplication.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.model.DropDownMenuItems
import com.example.myapplication.model.Item

@Composable
fun HomeGrid(items: List<Item>, onActionClick: (DropDownMenuActions, Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(2.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(
            items,
            span = { index, _ -> GridItemSpan(if (index % 3 == 0) 2 else 1) }) { index, items ->
            HomeGridItem(
                items = items,
                onActionClick = { onActionClick(it, index) }
            )
        }
    }
}
@Composable
fun HomeGridItem(items: Item, onActionClick: (DropDownMenuActions) -> Unit) {
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.inversePrimary)) {
        AsyncImage(
            model = items.thumb,
            contentDescription = "",
            modifier = Modifier
                .aspectRatio(1f)
                .background(Color.Red)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = items.title,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            DropDownMenuItems(onActionClick = onActionClick)
        }
    }
}
