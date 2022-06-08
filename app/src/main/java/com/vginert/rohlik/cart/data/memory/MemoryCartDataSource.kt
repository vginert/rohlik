package com.vginert.rohlik.cart.data.memory

import com.vginert.rohlik.shared.domain.Cart
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MemoryCartDataSource {

    private val _cartFlow: MutableStateFlow<Cart?> = MutableStateFlow(null)
    val cartFlow: Flow<Cart?> = _cartFlow

    fun setCart(cart: Cart) {
        _cartFlow.value = cart
    }

    fun getCart(): Cart? {
        return _cartFlow.value
    }
}
