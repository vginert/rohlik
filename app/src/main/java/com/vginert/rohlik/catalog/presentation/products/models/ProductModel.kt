package com.vginert.rohlik.catalog.presentation.products.models

import com.vginert.rohlik.catalog.domain.Product
import com.vginert.rohlik.shared.presentation.models.PriceModel
import com.vginert.rohlik.shared.presentation.models.asPresentation

data class ProductModel(
    val id: String,
    val name: String,
    val price: PriceModel,
    val imageUrl: String,
)

fun Product.asPresentation() = ProductModel(
    id = id,
    name = name,
    price = price.asPresentation(),
    imageUrl = imageUrl,
)
