package com.vginert.rohlik.catalog.domain.exceptions

class ProductNotFoundException(
    message: String? = null,
    cause: Throwable? = null,
) : Exception(message, cause)
