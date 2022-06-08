package com.vginert.rohlik.cart.presentation.cart.models

import com.vginert.rohlik.shared.domain.Cart
import com.vginert.rohlik.shared.presentation.models.ProductModel
import com.vginert.rohlik.shared.presentation.models.asPresentation

class CartModel(
    val items: List<Item>
) {

    companion object {
        fun empty() = CartModel(
            items = emptyList()
        )
    }

    data class Item(
        val product: ProductModel,
        val amount: Int,
    )
}

fun Cart.asPresentation() = CartModel(
    items = items.map { it.asPresentation() }
)

fun Cart.Item.asPresentation() = CartModel.Item(
    product = product.asPresentation(),
    amount = amount
)
