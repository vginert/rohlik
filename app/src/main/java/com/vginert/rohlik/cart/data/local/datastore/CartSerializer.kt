@file:Suppress("BlockingMethodInNonBlockingContext")

package com.vginert.rohlik.cart.data.local.datastore

import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

object CartSerializer : Serializer<CartDTO?> {

    override val defaultValue: CartDTO? = null

    override suspend fun readFrom(input: InputStream): CartDTO? {
        return try {
            CartDTO.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            null
        } catch (exception: IOException) {
            null
        }
    }

    override suspend fun writeTo(
        t: CartDTO?,
        output: OutputStream
    ) {
        try {
            t?.writeTo(output)
        } catch (exception: IOException) {
            // unused
        }
    }
}
