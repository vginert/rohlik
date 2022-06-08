package com.vginert.rohlik.shared.domain

import kotlinx.coroutines.flow.Flow

interface CartProvider {
    val cartFlow: Flow<Cart>
    suspend fun getCart(): Cart
    suspend fun setCart(cart: Cart)
}
