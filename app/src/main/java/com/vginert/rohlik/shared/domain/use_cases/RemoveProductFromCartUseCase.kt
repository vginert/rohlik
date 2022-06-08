package com.vginert.rohlik.shared.domain.use_cases

import com.vginert.rohlik.shared.domain.CartProvider
import com.vginert.rohlik.shared.domain.Product

class RemoveProductFromCartUseCase(
    private val cartProvider: CartProvider
) {
    suspend operator fun invoke(product: Product) {
        val cart = cartProvider.getCart().removeProduct(product)
        cartProvider.setCart(cart)
    }
}
