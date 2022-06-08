package com.vginert.rohlik.shared.domain.use_cases

import com.vginert.rohlik.shared.domain.CartProvider

class ClearCartUseCase(
    private val cartProvider: CartProvider
) {

    suspend operator fun invoke() {
        val cart = cartProvider.getCart().clear()
        cartProvider.setCart(cart)
    }
}
