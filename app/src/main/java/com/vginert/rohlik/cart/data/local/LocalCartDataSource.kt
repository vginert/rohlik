package com.vginert.rohlik.cart.data.local

import com.vginert.rohlik.shared.domain.Cart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class LocalCartDataSource {

    private var cart = Cart(
        items = listOf(
            Cart.Item(UUID.randomUUID().toString(), "Fish"),
            Cart.Item(UUID.randomUUID().toString(), "Meat"),
            Cart.Item(UUID.randomUUID().toString(), "Drinks"),
            Cart.Item(UUID.randomUUID().toString(), "Fruit"),
        )
    )

    suspend fun getCart(): Cart? {
        return withContext(Dispatchers.IO) { cart }
    }

    suspend fun setCart(cart: Cart) {
        withContext(Dispatchers.IO) { this@LocalCartDataSource.cart = cart }
    }
}
