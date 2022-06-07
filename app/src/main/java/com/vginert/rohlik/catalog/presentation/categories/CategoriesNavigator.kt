package com.vginert.rohlik.catalog.presentation.categories

import androidx.navigation.NavController
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.PRODUCTS_ROUTE

class CategoriesNavigator(
    private val navController: NavController
) {
    fun goToProductsScreen(categoryId: String, categoryName: String) {
        navController.navigate("$PRODUCTS_ROUTE/$categoryId/$categoryName")
    }
}
