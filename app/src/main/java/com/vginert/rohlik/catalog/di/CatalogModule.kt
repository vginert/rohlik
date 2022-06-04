package com.vginert.rohlik.catalog.di

import com.vginert.rohlik.catalog.presentation.categories.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val catalogModule = module {
    viewModel { CategoriesViewModel() }
}
