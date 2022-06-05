package com.vginert.rohlik.catalog.domain.use_cases

import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.catalog.domain.ProductDetails

class GetProductDetailsUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend operator fun invoke(productId: String): ProductDetails {
        return catalogRepository.getProductDetails(productId)
    }
}
