package com.vginert.rohlik.catalog.di

import com.vginert.rohlik.catalog.domain.use_cases.GetCategoriesUseCase
import com.vginert.rohlik.catalog.presentation.categories.CategoriesViewModel
import com.vginert.rohlik.catalog.presentation.products.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val catalogModule = module {
    factory { GetCategoriesUseCase() }
    viewModel { CategoriesViewModel(get()) }
    viewModel { ProductsViewModel(get()) }
}
