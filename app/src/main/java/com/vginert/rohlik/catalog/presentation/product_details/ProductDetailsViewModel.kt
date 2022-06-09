package com.vginert.rohlik.catalog.presentation.product_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vginert.rohlik.catalog.domain.ProductDetails
import com.vginert.rohlik.catalog.domain.exceptions.ProductNotFoundException
import com.vginert.rohlik.catalog.domain.use_cases.GetProductDetailsUseCase
import com.vginert.rohlik.catalog.presentation.product_details.models.asPresentation
import com.vginert.rohlik.shared.core.coroutines.executeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val productId: String,
    private val getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductDetailsState())
    val uiState: StateFlow<ProductDetailsState> = _uiState

    init {
        fetchProductDetail()
    }

    private fun fetchProductDetail() = viewModelScope.launch {
        _uiState.update { state -> state.copy(showContentNotFound = false, isLoadingContent = true) }
        executeUseCase { getProductDetailsUseCase(productId) }
            .onSuccess(::onFetchProductDetailSuccess)
            .onFailure(::onFetchProductDetailFail)
        _uiState.update { state -> state.copy(isLoadingContent = false) }
    }

    private fun onFetchProductDetailSuccess(productDetails: ProductDetails) {
        _uiState.update { state ->
            state.copy(productDetails = productDetails.asPresentation())
        }
    }

    private fun onFetchProductDetailFail(error: Throwable) {
        when (error) {
            is ProductNotFoundException -> _uiState.update { state -> state.copy(showContentNotFound = true) }
            else -> _uiState.update { state -> state.copy(showGenericError = true) }
        }
    }
}
