package com.vginert.rohlik.cart.domain

import com.vginert.rohlik.shared.domain.Cart

interface CartRepository {
    suspend fun setCart(cart: Cart)
}
