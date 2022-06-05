package com.vginert.rohlik.catalog.presentation.product_details.models

import com.vginert.rohlik.catalog.domain.ProductDetails

data class ProductDetailsModel(
    val id: String,
    val name: String,
)

fun ProductDetails.asPresentation() = ProductDetailsModel(
    id = id,
    name = name,
)
