package com.vginert.rohlik.shared.domain

data class Product(
    val id: String,
    val name: String,
    val price: Price,
    val imageUrl: String,
)
