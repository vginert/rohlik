package com.vginert.rohlik.catalog.domain.use_cases

import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.shared.domain.Product
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

internal class GetProductsFromCategoryUseCaseTest {

    private val catalogRepository: CatalogRepository = mockk()

    private val getProductsFromCategoryUseCase = GetProductsFromCategoryUseCase(catalogRepository)

    @Test
    fun `On invoke should return products from the repository`() = runTest {
        val categoryId = UUID.randomUUID().toString()
        val products: List<Product> = mockk()
        coEvery { catalogRepository.getProducts(categoryId) } returns products

        val result = getProductsFromCategoryUseCase(categoryId)

        assertEquals(products, result)
        coVerify { catalogRepository.getProducts(categoryId) }
        confirmVerified(catalogRepository)
    }
}
