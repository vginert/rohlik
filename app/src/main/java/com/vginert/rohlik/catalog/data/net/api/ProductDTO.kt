package com.vginert.rohlik.catalog.data.net.api

import com.squareup.moshi.JsonClass
import com.vginert.rohlik.shared.data.api.models.PriceDTO

@JsonClass(generateAdapter = true)
data class ProductDTO(
    val id: String,
    val name: String,
    val price: PriceDTO,
    val image_url: String,
)
