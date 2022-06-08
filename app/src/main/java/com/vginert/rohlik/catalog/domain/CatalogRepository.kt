package com.vginert.rohlik.catalog.domain

import com.vginert.rohlik.shared.domain.Product

interface CatalogRepository {
    suspend fun getCategories(): List<Category>
    suspend fun getProducts(categoryId: String): List<Product>
    suspend fun getProductDetails(productId: String): ProductDetails
}
