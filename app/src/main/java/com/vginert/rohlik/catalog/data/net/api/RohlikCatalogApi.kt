package com.vginert.rohlik.catalog.data.net.api

import com.vginert.rohlik.shared.data.api.ProductDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface RohlikCatalogApi {

    @GET("category.json")
    suspend fun getCategories(): List<CategoryDTO>

    @GET("category/{categoryId}.json")
    suspend fun getProducts(@Path("categoryId") categoryId: String): List<ProductDTO>

    @GET("TODO/{productId}")
    suspend fun getProductDetails(@Path("productId") productId: String): ProductDetailsDTO
}
