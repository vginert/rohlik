package com.vginert.rohlik.catalog.di

import com.vginert.rohlik.catalog.data.CatalogDataRepository
import com.vginert.rohlik.catalog.data.net.NetCatalogDataSource
import com.vginert.rohlik.catalog.data.net.api.RohlikCatalogApi
import com.vginert.rohlik.catalog.domain.CatalogRepository
import com.vginert.rohlik.catalog.domain.use_cases.GetCategoriesUseCase
import com.vginert.rohlik.catalog.domain.use_cases.GetProductDetailsUseCase
import com.vginert.rohlik.catalog.domain.use_cases.GetProductsFromCategoryUseCase
import com.vginert.rohlik.catalog.presentation.categories.CategoriesViewModel
import com.vginert.rohlik.catalog.presentation.product_details.ProductDetailsViewModel
import com.vginert.rohlik.catalog.presentation.products.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val catalogModule = module {
    factory { get<Retrofit>().create(RohlikCatalogApi::class.java) }
    factory { NetCatalogDataSource(get()) }
    single<CatalogRepository> { CatalogDataRepository(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { GetProductsFromCategoryUseCase(get()) }
    factory { GetProductDetailsUseCase(get()) }
    viewModel { CategoriesViewModel(get()) }
    viewModel { (categoryId: String, categoryName: String) -> ProductsViewModel(categoryId, categoryName, get()) }
    viewModel { ProductDetailsViewModel(get(), get()) }
}
