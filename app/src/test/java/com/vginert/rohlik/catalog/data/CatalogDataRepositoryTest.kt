package com.vginert.rohlik.catalog.data

import com.vginert.rohlik.catalog.data.net.NetCatalogDataSource
import com.vginert.rohlik.catalog.domain.Category
import com.vginert.rohlik.catalog.domain.ProductDetails
import com.vginert.rohlik.shared.domain.Product
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

internal class CatalogDataRepositoryTest {

    private val netDataSource: NetCatalogDataSource = mockk()

    private val catalogDataRepository = CatalogDataRepository(netDataSource)

    @Test
    fun `On get categories should return them from net data source`() = runTest {
        val categories: List<Category> = mockk()
        coEvery { netDataSource.getCategories() } returns categories

        val result = catalogDataRepository.getCategories()

        assertEquals(categories, result)
        coVerify { netDataSource.getCategories() }
        confirmVerified(netDataSource)
    }

    @Test
    fun `On get products should return them from net data source`() = runTest {
        val categoryId = UUID.randomUUID().toString()
        val products: List<Product> = mockk()
        coEvery { netDataSource.getProducts(categoryId) } returns products

        val result = catalogDataRepository.getProducts(categoryId)

        assertEquals(products, result)
        coVerify { netDataSource.getProducts(categoryId) }
        confirmVerified(netDataSource)
    }

    @Test
    fun `On get product details should return them from net data source`() = runTest {
        val productId = UUID.randomUUID().toString()
        val productDetails: ProductDetails = mockk()
        coEvery { netDataSource.getProductDetails(productId) } returns productDetails

        val result = catalogDataRepository.getProductDetails(productId)

        assertEquals(productDetails, result)
        coVerify { netDataSource.getProductDetails(productId) }
        confirmVerified(netDataSource)
    }
}
