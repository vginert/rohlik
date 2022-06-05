package com.vginert.rohlik.cart.di

import com.vginert.rohlik.cart.presentation.cart.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartModule = module {
    viewModel { CartViewModel() }
}
