package com.vginert.rohlik.catalog.data.net

import com.vginert.rohlik.catalog.data.net.api.CategoryDTO
import com.vginert.rohlik.catalog.data.net.api.ProductDetailsDTO
import com.vginert.rohlik.catalog.data.net.api.RohlikCatalogApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

internal class NetCatalogDataSourceTest {

    private val api: RohlikCatalogApi = mockk()

    private val netCatalogDataSource = NetCatalogDataSource(api)

    @Test
    fun `On get categories should return them from the api`() = runTest {
        val categoryDTOList = listOf(
            CategoryDTO(
                id = UUID.randomUUID().toString(),
                name = "Random test name",
                image_url = "Random test image url"
            )
        )
        coEvery { api.getCategories() } returns categoryDTOList

        val result = netCatalogDataSource.getCategories()

        assertEquals(result.size, categoryDTOList.size)
        assertEquals(categoryDTOList[0].id, result[0].id)
        assertEquals(categoryDTOList[0].name, result[0].name)
        assertEquals(categoryDTOList[0].image_url, result[0].imageUrl)
        coVerify { api.getCategories() }
        confirmVerified(api)
    }

    @Test
    fun `On get product details should return them from the api`() = runTest {
        val productId = UUID.randomUUID().toString()
        val productDetailsDTO = ProductDetailsDTO(
            id = productId,
            name = "Random test name",
        )
        coEvery { api.getProductDetails(productId) } returns productDetailsDTO

        val result = netCatalogDataSource.getProductDetails(productId)

        assertEquals(productDetailsDTO.id, result.id)
        assertEquals(productDetailsDTO.name, result.name)
        coVerify { api.getProductDetails(productId) }
        confirmVerified(api)
    }
}
