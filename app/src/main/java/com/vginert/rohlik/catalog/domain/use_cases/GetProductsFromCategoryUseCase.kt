package com.vginert.rohlik.catalog.domain.use_cases

import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.shared.domain.Product

class GetProductsFromCategoryUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend operator fun invoke(categoryId: String): List<Product> {
        return catalogRepository.getProducts(categoryId)
    }
}
