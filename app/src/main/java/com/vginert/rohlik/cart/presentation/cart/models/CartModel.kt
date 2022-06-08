package com.vginert.rohlik.cart.presentation.cart.models

import com.vginert.rohlik.shared.domain.Cart

class CartModel(
    val items: List<Item>
) {

    companion object {
        fun empty() = CartModel(
            items = emptyList()
        )
    }

    data class Item(
        val id: String,
        val name: String,
    )
}

fun Cart.asPresentation() = CartModel(
    items = items.map { it.asPresentation() }
)

fun Cart.Item.asPresentation() = CartModel.Item(
    id = id,
    name = name
)
