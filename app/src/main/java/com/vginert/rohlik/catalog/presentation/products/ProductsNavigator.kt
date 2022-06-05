package com.vginert.rohlik.catalog.presentation.products

import androidx.navigation.NavController
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.PRODUCT_DETAILS_ROUTE

class ProductsNavigator(
    private val navController: NavController
) {

    fun goToProductDetails(productId: String) {
        navController.navigate("$PRODUCT_DETAILS_ROUTE/$productId")
    }

    fun goBack() {
        navController.popBackStack()
    }
}
