package com.vginert.rohlik.catalog.presentation.products

import androidx.navigation.NavController

class ProductsNavigator(
    private val navController: NavController
) {

    fun goBack() {
        navController.popBackStack()
    }
}
