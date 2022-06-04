package com.vginert.rohlik.catalog.presentation.categories.models

import com.vginert.rohlik.catalog.domain.Category

data class CategoryModel(
    val id: String,
    val name: String
)

fun Category.asPresentation() = CategoryModel(
    id = id,
    name = name,
)
