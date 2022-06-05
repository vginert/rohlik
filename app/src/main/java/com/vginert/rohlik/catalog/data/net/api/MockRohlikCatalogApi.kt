package com.vginert.rohlik.catalog.data.net.api

import com.vginert.rohlik.catalog.domain.exceptions.CategoryNotFoundException
import com.vginert.rohlik.catalog.domain.exceptions.ProductNotFoundException
import java.util.*

class MockRohlikCatalogApi : RohlikCatalogApi {

    private val catalog = hashMapOf(
        CategoryDTO(id = UUID.randomUUID().toString(), "Fruit") to listOf(
            ProductDTO(id = UUID.randomUUID().toString(), "Apple"),
            ProductDTO(id = UUID.randomUUID().toString(), "Pineapple"),
            ProductDTO(id = UUID.randomUUID().toString(), "Banana"),
            ProductDTO(id = UUID.randomUUID().toString(), "Orange"),
        ),
        CategoryDTO(id = UUID.randomUUID().toString(), "Drinks") to listOf(
            ProductDTO(id = UUID.randomUUID().toString(), "Water"),
            ProductDTO(id = UUID.randomUUID().toString(), "Cola"),
            ProductDTO(id = UUID.randomUUID().toString(), "Lemonade"),
            ProductDTO(id = UUID.randomUUID().toString(), "Orange juice"),
            ProductDTO(id = UUID.randomUUID().toString(), "Beer"),
        ),
        CategoryDTO(id = UUID.randomUUID().toString(), "Meat") to listOf(
            ProductDTO(id = UUID.randomUUID().toString(), "Beef"),
            ProductDTO(id = UUID.randomUUID().toString(), "Lamb"),
            ProductDTO(id = UUID.randomUUID().toString(), "Goat"),
            ProductDTO(id = UUID.randomUUID().toString(), "Chicken"),
            ProductDTO(id = UUID.randomUUID().toString(), "Turkey"),
        ),
        CategoryDTO(id = UUID.randomUUID().toString(), "Fish") to listOf(
            ProductDTO(id = UUID.randomUUID().toString(), "Shad"),
            ProductDTO(id = UUID.randomUUID().toString(), "Salmon"),
            ProductDTO(id = UUID.randomUUID().toString(), "Tuna"),
            ProductDTO(id = UUID.randomUUID().toString(), "Cod"),
        )
    )

    override suspend fun getCategories(): List<CategoryDTO> {
        return catalog.keys.toList()
    }

    override suspend fun getProducts(categoryId: String): List<ProductDTO> {
        val category = catalog.keys.find { it.id == categoryId }
            ?: throw CategoryNotFoundException()
        return catalog[category] ?: throw CategoryNotFoundException()
    }

    override suspend fun getProductDetails(productId: String): ProductDetailsDTO {
        val product = catalog.values.flatten().find { it.id == productId }
            ?: throw ProductNotFoundException()
        return ProductDetailsDTO(product.id, product.name)
    }
}
