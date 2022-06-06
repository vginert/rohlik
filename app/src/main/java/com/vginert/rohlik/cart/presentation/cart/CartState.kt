package com.vginert.rohlik.cart.presentation.cart

import com.vginert.rohlik.cart.presentation.cart.models.CartModel

data class CartState(
    val cart: CartModel = CartModel.empty()
)
