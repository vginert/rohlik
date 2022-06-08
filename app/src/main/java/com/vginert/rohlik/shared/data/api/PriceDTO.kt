package com.vginert.rohlik.shared.data.api

import com.squareup.moshi.JsonClass
import com.vginert.rohlik.shared.domain.Price
import java.util.*

@JsonClass(generateAdapter = true)
data class PriceDTO(
    val amount: Double,
    val currency: String,
)

fun PriceDTO.asDomain() = Price(
    amount = amount,
    currency = Currency.getInstance(currency)
)
