package com.vginert.rohlik.cart.domain

import kotlinx.coroutines.flow.Flow

interface CartRepository {
    val cartFlow: Flow<Cart>
    suspend fun setCart(cart: Cart)
}
