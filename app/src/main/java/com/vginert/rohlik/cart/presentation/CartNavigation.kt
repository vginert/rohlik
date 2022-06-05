package com.vginert.rohlik.cart.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vginert.rohlik.cart.presentation.CartNavigation.CART_ROUTE
import com.vginert.rohlik.cart.presentation.cart.CartRoute
import com.vginert.rohlik.shared.presentation.navigation.GlobalNavigation.CART_ROUTE as GLOBAL_CART_ROUTE

object CartNavigation {
    const val CART_ROUTE = "cart_cart"
}

fun NavGraphBuilder.cartNavGraph(navController: NavController) {
    navigation(
        startDestination = CART_ROUTE,
        route = GLOBAL_CART_ROUTE
    ) {
        composable(CART_ROUTE) {
            CartRoute()
        }
    }
}
