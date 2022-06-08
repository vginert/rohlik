package com.vginert.rohlik.cart.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore

private const val CART_DATA_STORE_FILE_NAME = "cart_store.pb"

val Context.cartDataStore: DataStore<CartDTO?> by dataStore(
    fileName = CART_DATA_STORE_FILE_NAME,
    serializer = CartSerializer
)
