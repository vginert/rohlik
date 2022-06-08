package com.vginert.rohlik.catalog.data.net

import com.vginert.rohlik.catalog.data.net.api.CategoryDTO
import com.vginert.rohlik.shared.data.api.ProductDTO
import com.vginert.rohlik.catalog.data.net.api.ProductDetailsDTO
import com.vginert.rohlik.catalog.data.net.api.RohlikCatalogApi
import com.vginert.rohlik.catalog.domain.Category
import com.vginert.rohlik.shared.domain.Product
import com.vginert.rohlik.catalog.domain.ProductDetails
import com.vginert.rohlik.shared.data.api.asDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetCatalogDataSource(
    private val api: RohlikCatalogApi
) {

    suspend fun getCategories(): List<Category> {
        return withContext(Dispatchers.IO) { api.getCategories() }.map { it.asDomain() }
    }

    suspend fun getProducts(categoryId: String): List<Product> {
        return withContext(Dispatchers.IO) { api.getProducts(categoryId = categoryId) }.map { it.asDomain() }
    }

    suspend fun getProductDetails(productId: String): ProductDetails {
        return withContext(Dispatchers.IO) { api.getProductDetails(productId = productId) }.asDomain()
    }

    private fun CategoryDTO.asDomain() = Category(
        id = id,
        name = name,
        imageUrl = image_url,
    )

    private fun ProductDTO.asDomain() = Product(
        id = id,
        name = name,
        price = price.asDomain(),
        imageUrl = image_url,
    )

    private fun ProductDetailsDTO.asDomain() = ProductDetails(
        id = id,
        name = name,
    )
}
