package com.vginert.rohlik.shared.data.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDTO(
    val id: String,
    val name: String,
    val price: PriceDTO,
    val image_url: String,
)
