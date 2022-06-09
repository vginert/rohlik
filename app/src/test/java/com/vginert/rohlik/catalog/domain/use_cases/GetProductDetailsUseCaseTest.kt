package com.vginert.rohlik.catalog.domain.use_cases

import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.catalog.domain.ProductDetails
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

internal class GetProductDetailsUseCaseTest {

    private val catalogRepository: CatalogRepository = mockk()

    private val getProductDetailsUseCase = GetProductDetailsUseCase(catalogRepository)

    @Test
    fun `On invoke should return product details from the repository`() = runTest {
        val productId = UUID.randomUUID().toString()
        val productDetails: ProductDetails = mockk()
        coEvery { catalogRepository.getProductDetails(productId) } returns productDetails

        val result = getProductDetailsUseCase(productId)

        assertEquals(productDetails, result)
        coVerify { catalogRepository.getProductDetails(productId) }
        confirmVerified(catalogRepository)
    }
}
