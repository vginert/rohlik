package com.vginert.rohlik.shared.domain.use_cases

import com.vginert.rohlik.shared.domain.Cart
import com.vginert.rohlik.shared.domain.CartProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class SubscribeToCartUseCase(
    private val cartProvider: CartProvider
) {
    operator fun invoke(): Flow<Cart> = cartProvider.cartFlow.distinctUntilChanged()
}
