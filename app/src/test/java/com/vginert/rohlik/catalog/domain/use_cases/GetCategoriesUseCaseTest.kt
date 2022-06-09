package com.vginert.rohlik.catalog.domain.use_cases

import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.catalog.domain.Category
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

internal class GetCategoriesUseCaseTest {

    private val catalogRepository: CatalogRepository = mockk()

    private val getCategoriesUseCase = GetCategoriesUseCase(catalogRepository)

    @Test
    fun `On invoke should return the categories from the repository`() = runTest {
        val categories: List<Category> = mockk()
        coEvery { catalogRepository.getCategories() } returns categories

        val result = getCategoriesUseCase()

        assertEquals(categories, result)
        coVerify { catalogRepository.getCategories() }
        confirmVerified(catalogRepository)
    }
}
