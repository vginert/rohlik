package com.vginert.rohlik.catalog.data

import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.catalog.domain.Category
import com.vginert.rohlik.catalog.domain.Product
import com.vginert.rohlik.catalog.domain.exceptions.CategoryNotFoundException
import java.util.*

class CatalogDataRepository : CatalogRepository {

    private val catalog = hashMapOf(
        Category(id = UUID.randomUUID().toString(), "Fruit") to listOf(
            Product(id = UUID.randomUUID().toString(), "Apple"),
            Product(id = UUID.randomUUID().toString(), "Pineapple"),
            Product(id = UUID.randomUUID().toString(), "Banana"),
            Product(id = UUID.randomUUID().toString(), "Orange"),
        ),
        Category(id = UUID.randomUUID().toString(), "Drinks") to listOf(
            Product(id = UUID.randomUUID().toString(), "Water"),
            Product(id = UUID.randomUUID().toString(), "Cola"),
            Product(id = UUID.randomUUID().toString(), "Lemonade"),
            Product(id = UUID.randomUUID().toString(), "Orange juice"),
            Product(id = UUID.randomUUID().toString(), "Beer"),
        ),
        Category(id = UUID.randomUUID().toString(), "Meat") to listOf(
            Product(id = UUID.randomUUID().toString(), "Beef"),
            Product(id = UUID.randomUUID().toString(), "Lamb"),
            Product(id = UUID.randomUUID().toString(), "Goat"),
            Product(id = UUID.randomUUID().toString(), "Chicken"),
            Product(id = UUID.randomUUID().toString(), "Turkey"),
        ),
        Category(id = UUID.randomUUID().toString(), "Fish") to listOf(
            Product(id = UUID.randomUUID().toString(), "Shad"),
            Product(id = UUID.randomUUID().toString(), "Salmon"),
            Product(id = UUID.randomUUID().toString(), "Tuna"),
            Product(id = UUID.randomUUID().toString(), "Cod"),
        )
    )

    override suspend fun getCategories(): List<Category> {
        return catalog.keys.toList()
    }

    override suspend fun getProducts(categoryId: String): List<Product> {
        val category = catalog.keys.find { it.id == categoryId }
            ?: throw CategoryNotFoundException()
        return catalog[category] ?: throw CategoryNotFoundException()
    }
}
