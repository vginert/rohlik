package com.vginert.rohlik.shared.domain

data class Cart(
    val items: List<Item>
) {

    companion object {
        fun empty() = Cart(
            items = emptyList()
        )
    }

    data class Item(
        val id: String,
        val name: String,
    )
}
