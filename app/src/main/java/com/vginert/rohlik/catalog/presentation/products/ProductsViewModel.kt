package com.vginert.rohlik.catalog.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vginert.rohlik.catalog.domain.exceptions.CategoryNotFoundException
import com.vginert.rohlik.catalog.domain.use_cases.GetProductsFromCategoryUseCase
import com.vginert.rohlik.shared.core.coroutines.executeUseCase
import com.vginert.rohlik.shared.domain.Product
import com.vginert.rohlik.shared.domain.use_cases.AddProductToCartUseCase
import com.vginert.rohlik.shared.presentation.models.ProductModel
import com.vginert.rohlik.shared.presentation.models.asDomain
import com.vginert.rohlik.shared.presentation.models.asPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val categoryId: String,
    categoryName: String,
    private val getProductsFromCategoryUseCase: GetProductsFromCategoryUseCase,
    private val addProductToCartUseCase: AddProductToCartUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductsState(title = categoryName))
    val uiState: StateFlow<ProductsState> = _uiState

    init {
        fetchProducts()
    }

    fun onAddToCartClick(product: ProductModel) = viewModelScope.launch {
        executeUseCase { addProductToCartUseCase(product.asDomain()) }
            .onFailure(::addProductToCartFail)
    }

    fun onGenericErrorDismissed() {
        _uiState.update { state -> state.copy(showGenericError = false) }
    }

    private fun fetchProducts() = viewModelScope.launch {
        _uiState.update { state -> state.copy(showContentNotFound = false, isLoadingContent = true) }
        executeUseCase { getProductsFromCategoryUseCase(categoryId) }
            .onSuccess(::onFetchProductsSuccess)
            .onFailure(::onFetchProductsFail)
        _uiState.update { state -> state.copy(isLoadingContent = false) }
    }

    private fun onFetchProductsSuccess(products: List<Product>) {
        _uiState.update { state ->
            state.copy(products = products.map { it.asPresentation() })
        }
    }

    private fun onFetchProductsFail(error: Throwable) {
        when (error) {
            is CategoryNotFoundException -> _uiState.update { state -> state.copy(showContentNotFound = true) }
            else -> _uiState.update { state -> state.copy(showGenericError = true) }
        }
    }

    private fun addProductToCartFail(error: Throwable) {
        _uiState.update { state -> state.copy(showGenericError = true) }
    }
}
