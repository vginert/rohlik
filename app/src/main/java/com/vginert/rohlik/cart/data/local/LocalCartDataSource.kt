package com.vginert.rohlik.cart.data.local

import android.content.Context
import com.vginert.rohlik.cart.data.local.datastore.CartDTO
import com.vginert.rohlik.cart.data.local.datastore.cartDataStore
import com.vginert.rohlik.shared.data.local.PriceDTO
import com.vginert.rohlik.shared.data.local.ProductDTO
import com.vginert.rohlik.shared.domain.Cart
import com.vginert.rohlik.shared.domain.Price
import com.vginert.rohlik.shared.domain.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import java.util.*

class LocalCartDataSource(
    context: Context
) {
    private val dataStore = context.cartDataStore

    suspend fun getCart(): Cart? {
        return withContext(Dispatchers.IO) { dataStore.data.firstOrNull()?.asDomain() }
    }

    suspend fun setCart(cart: Cart) {
        withContext(Dispatchers.IO) {
            dataStore.updateData { cart.asLocal() }
        }
    }

    private fun CartDTO.asDomain() = Cart(
        items = itemsList.map { it.asDomain() },
    )

    private fun CartDTO.Item.asDomain() = Cart.Item(
        product = product.asDomain(),
        amount = amount,
    )

    private fun ProductDTO.asDomain() = Product(
        id = id,
        name = name,
        price = price.asDomain(),
        imageUrl = imageUrl,
    )

    private fun PriceDTO.asDomain() = Price(
        amount = amount,
        currency = Currency.getInstance(currency),
    )

    private fun Cart.asLocal() = CartDTO.newBuilder()
        .addAllItems(items.map { it.asLocal() })
        .build()

    private fun Cart.Item.asLocal() = CartDTO.Item.newBuilder()
        .setProduct(product.asLocal())
        .setAmount(amount)
        .build()

    private fun Product.asLocal() = ProductDTO.newBuilder()
        .setId(id)
        .setName(name)
        .setPrice(price.asLocal())
        .setImageUrl(imageUrl)
        .build()

    private fun Price.asLocal() = PriceDTO.newBuilder()
        .setAmount(amount)
        .setCurrency(currency.currencyCode)
        .build()
}
