package com.vginert.rohlik.catalog.presentation.products

import androidx.navigation.NavController
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.PRODUCT_DETAILS_ROUTE
import com.vginert.rohlik.shared.presentation.navigation.GlobalNavigation

class ProductsNavigator(
    private val navController: NavController
) {

    fun goToProductDetails(productId: String) {
        navController.navigate("$PRODUCT_DETAILS_ROUTE/$productId")
    }

    fun goToCart() {
        navController.navigate(GlobalNavigation.CART_ROUTE)
    }

    fun goBack() {
        navController.popBackStack()
    }
}
