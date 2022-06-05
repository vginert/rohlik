package com.vginert.rohlik.catalog.domain.exceptions

class CategoryNotFoundException(
    message: String? = null,
    cause: Throwable? = null,
) : Exception(message, cause)
