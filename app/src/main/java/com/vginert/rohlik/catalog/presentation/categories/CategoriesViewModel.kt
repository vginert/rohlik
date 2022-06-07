package com.vginert.rohlik.catalog.presentation.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vginert.rohlik.catalog.domain.Category
import com.vginert.rohlik.catalog.domain.use_cases.GetCategoriesUseCase
import com.vginert.rohlik.catalog.presentation.categories.models.asPresentation
import com.vginert.rohlik.shared.core.coroutines.executeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesState())
    val uiState: StateFlow<CategoriesState> = _uiState

    init {
        fetchCategories()
    }

    private fun fetchCategories() = viewModelScope.launch {
        _uiState.update { state -> state.copy(isLoadingContent = true) }
        executeUseCase { getCategoriesUseCase() }
            .onSuccess(::onFetchCategoriesSuccess)
            .onFailure(::onFetchCategoriesFail)
        _uiState.update { state -> state.copy(isLoadingContent = false) }
    }

    private fun onFetchCategoriesSuccess(categories: List<Category>) {
        _uiState.update { state ->
            state.copy(categories = categories.map { it.asPresentation() })
        }
    }

    private fun onFetchCategoriesFail(error: Throwable) {
        TODO()
    }
}
