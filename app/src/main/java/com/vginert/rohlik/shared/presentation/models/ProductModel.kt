package com.vginert.rohlik.shared.presentation.models

import com.vginert.rohlik.shared.domain.Product

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

fun ProductModel.asDomain() = Product(
    id = id,
    name = name,
    price = price.asDomain(),
    imageUrl = imageUrl,
)
