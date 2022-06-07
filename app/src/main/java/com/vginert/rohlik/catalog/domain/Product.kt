package com.vginert.rohlik.catalog.domain

import com.vginert.rohlik.shared.domain.models.Price

data class Product(
    val id: String,
    val name: String,
    val price: Price,
    val imageUrl: String,
)
