package com.vginert.rohlik.cart.domain.use_cases

import com.vginert.rohlik.cart.domain.Cart
import com.vginert.rohlik.cart.domain.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class SubscribeToCartUseCase(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<Cart> = cartRepository.cartFlow.distinctUntilChanged()
}
