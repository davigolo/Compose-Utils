package com.example.myapplication.ui.screens.home

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.model.DropDownMenuItems
import com.example.myapplication.model.Item


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomListItem(item: Item, onMenuActionClick: (DropDownMenuActions) -> Unit) {
    ListItem(
        headlineText = { Text(text = item.title) },
        supportingText = { Text(text = item.description) },
        trailingContent = {
            DropDownMenuItems(onActionClick = onMenuActionClick) },
        leadingContent = {
            AsyncImage(
                model = item.thumb,
                contentDescription = "Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(48.dp)
            )
        })
}