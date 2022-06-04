package com.vginert.rohlik.catalog.domain.use_cases

import com.vginert.rohlik.catalog.domain.Category
import java.util.*

class GetCategoriesUseCase {

    suspend operator fun invoke(): List<Category> {
        return listOf(
            Category(id = UUID.randomUUID().toString(), "Fruit"),
            Category(id = UUID.randomUUID().toString(), "Drinks"),
            Category(id = UUID.randomUUID().toString(), "Meat"),
            Category(id = UUID.randomUUID().toString(), "Fish"),
        )
    }
}
