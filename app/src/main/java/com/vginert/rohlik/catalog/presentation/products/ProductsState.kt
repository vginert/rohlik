package com.vginert.rohlik.catalog.presentation.products

import com.vginert.rohlik.shared.presentation.models.ProductModel

data class ProductsState(
    val title: String = "",
    val products: List<ProductModel> = emptyList(),
    val isLoadingContent: Boolean = false,
    val showContentNotFound: Boolean = false,
    val showGenericError: Boolean = false,
)
