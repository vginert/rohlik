package com.vginert.rohlik.catalog.presentation.product_details

import com.vginert.rohlik.catalog.presentation.product_details.models.ProductDetailsModel

data class ProductDetailsState(
    val productDetails: ProductDetailsModel? = null,
    val isLoadingContent: Boolean = false,
    val showContentNotFound: Boolean = false,
    val showGenericError: Boolean = false,
)
