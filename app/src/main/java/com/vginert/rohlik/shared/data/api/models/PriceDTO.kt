package com.vginert.rohlik.shared.data.api.models

import com.squareup.moshi.JsonClass
import com.vginert.rohlik.shared.domain.models.Price
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
