package com.vginert.rohlik.catalog.data.net.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryDTO(
    val id: String,
    val name: String,
    val image_url: String,
)
