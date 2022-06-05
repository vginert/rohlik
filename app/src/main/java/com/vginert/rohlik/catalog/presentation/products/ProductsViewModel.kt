package com.vginert.rohlik.catalog.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vginert.rohlik.catalog.domain.Product
import com.vginert.rohlik.catalog.domain.use_cases.GetProductsFromCategoryUseCase
import com.vginert.rohlik.catalog.presentation.products.models.asPresentation
import com.vginert.rohlik.shared.core.coroutines.executeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val categoryId: String,
    private val getProductsFromCategoryUseCase: GetProductsFromCategoryUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductsState())
    val uiState: StateFlow<ProductsState> = _uiState

    init {
        fetchProducts()
    }

    private fun fetchProducts() = viewModelScope.launch {
        executeUseCase { getProductsFromCategoryUseCase(categoryId) }
            .onSuccess(::onFetchProductsSuccess)
            .onFailure(::onFetchProductsFail)
    }

    private fun onFetchProductsSuccess(products: List<Product>) {
        _uiState.update { state ->
            state.copy(products = products.map { it.asPresentation() })
        }
    }

    private fun onFetchProductsFail(error: Throwable) {
        TODO()
    }
}
