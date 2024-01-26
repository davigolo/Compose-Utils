package com.example.myapplication.model

data class Item(
    val title: String,
    val description: String,
    val thumb: String,
    val id: Int
)

var itemList = (1..1000).map {
    Item(
        title = "Item $it",
        description = "Description $it",
        id = it,
        thumb = "https://source.unsplash.com/random/200x200?sig=$it"
    )
}
