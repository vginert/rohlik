package com.vginert.rohlik.cart.data

import com.vginert.rohlik.cart.data.local.LocalCartDataSource
import com.vginert.rohlik.cart.data.memory.MemoryCartDataSource
import com.vginert.rohlik.cart.domain.CartRepository
import com.vginert.rohlik.shared.domain.Cart
import com.vginert.rohlik.shared.domain.CartProvider
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CartDataRepository(
    private val memoryDataSource: MemoryCartDataSource,
    private val localDataSource: LocalCartDataSource,
) : CartRepository, CartProvider {

    override val cartFlow: Flow<Cart> = memoryDataSource.cartFlow.map {
        it ?: getCartFromLocalAndSyncToMemory() ?: Cart.empty()
    }

    override suspend fun setCart(cart: Cart) {
        coroutineScope {
            launch { localDataSource.setCart(cart) }
            launch { memoryDataSource.setCart(cart) }
        }
    }

    private suspend fun getCartFromLocalAndSyncToMemory(): Cart? {
        return localDataSource.getCart()?.also {
            memoryDataSource.setCart(it)
        }
    }
}
