package com.vginert.rohlik.main.di

import com.vginert.rohlik.cart.data.CartDataRepository
import com.vginert.rohlik.shared.domain.CartProvider
import com.vginert.rohlik.shared.domain.use_cases.SubscribeToCartUseCase
import org.koin.dsl.module

val sharedModule = module {
    factory<CartProvider> { get<CartDataRepository>() }
    factory { SubscribeToCartUseCase(get()) }
}
