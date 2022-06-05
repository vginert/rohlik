package com.vginert.rohlik.catalog.data

import com.vginert.rohlik.catalog.data.net.NetCatalogDataSource
import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.catalog.domain.Category
import com.vginert.rohlik.catalog.domain.Product
import com.vginert.rohlik.catalog.domain.ProductDetails

class CatalogDataRepository(
    private val netDataSource: NetCatalogDataSource
) : CatalogRepository {

    override suspend fun getCategories(): List<Category> {
        return netDataSource.getCategories()
    }

    override suspend fun getProducts(categoryId: String): List<Product> {
        return netDataSource.getProducts(categoryId = categoryId)
    }

    override suspend fun getProductDetails(productId: String): ProductDetails {
        return netDataSource.getProductDetails(productId = productId)
    }
}
