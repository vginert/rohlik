package com.vginert.rohlik.cart.di

import com.vginert.rohlik.cart.data.CartDataRepository
import com.vginert.rohlik.cart.data.local.LocalCartDataSource
import com.vginert.rohlik.cart.data.memory.MemoryCartDataSource
import com.vginert.rohlik.cart.domain.CartRepository
import com.vginert.rohlik.cart.domain.use_cases.SubscribeToCartUseCase
import com.vginert.rohlik.cart.presentation.cart.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartModule = module {
    single { MemoryCartDataSource() }
    factory { LocalCartDataSource() }
    factory<CartRepository> { CartDataRepository(get(), get()) }
    factory { SubscribeToCartUseCase(get()) }
    viewModel { CartViewModel(get()) }
}
