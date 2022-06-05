package com.vginert.rohlik.catalog.presentation.products.models

import com.vginert.rohlik.catalog.domain.Product

data class ProductModel(
    val id: String,
    val name: String,
)

fun Product.asPresentation() = ProductModel(
    id = id,
    name = name
)
