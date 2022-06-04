package com.vginert.rohlik.catalog.presentation.categories

import com.vginert.rohlik.catalog.presentation.categories.models.CategoryModel

data class CategoriesState(
    val categories: List<CategoryModel> = emptyList()
)
