package com.vginert.rohlik.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vginert.rohlik.cart.presentation.cartNavGraph
import com.vginert.rohlik.catalog.presentation.catalogNavGraph
import com.vginert.rohlik.shared.presentation.navigation.GlobalNavigation

@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = GlobalNavigation.CATALOG_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        catalogNavGraph(navController = navController)
        cartNavGraph(navController = navController)
    }
}
