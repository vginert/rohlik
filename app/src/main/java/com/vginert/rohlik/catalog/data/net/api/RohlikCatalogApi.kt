package com.vginert.rohlik.catalog.data.net.api

import retrofit2.http.GET
import retrofit2.http.Path

interface RohlikCatalogApi {

    @GET("TODO")
    suspend fun getCategories(): List<CategoryDTO>

    @GET("TODO/{categoryId}")
    suspend fun getProducts(@Path("categoryId") categoryId: String): List<ProductDTO>

    @GET("TODO/{productId}")
    suspend fun getProductDetails(@Path("productId") productId: String): ProductDetailsDTO
}
