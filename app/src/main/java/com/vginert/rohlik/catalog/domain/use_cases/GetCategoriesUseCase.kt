package com.vginert.rohlik.catalog.domain.use_cases

import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.catalog.domain.Category

class GetCategoriesUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend operator fun invoke(): List<Category> {
        return catalogRepository.getCategories()
    }
}
