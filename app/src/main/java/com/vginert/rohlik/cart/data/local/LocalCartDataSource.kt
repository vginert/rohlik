package com.vginert.rohlik.cart.data.local

import android.util.Log
import com.vginert.rohlik.shared.domain.Cart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalCartDataSource {

    private var cart: Cart? = null

    suspend fun getCart(): Cart? {
        return withContext(Dispatchers.IO) { cart }
    }

    suspend fun setCart(cart: Cart) {
        withContext(Dispatchers.IO) {
            Log.d("CART", cart.items.toString())
            this@LocalCartDataSource.cart = cart
        }
    }
}
