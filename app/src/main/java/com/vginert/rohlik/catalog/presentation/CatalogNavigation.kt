package com.vginert.rohlik.catalog.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.vginert.rohlik.catalog.presentation.categories.CategoriesRoute
import com.vginert.rohlik.shared.presentation.navigation.GlobalNavigation

object CatalogNavigation {
    const val CATEGORIES_ROUTE = "catalog_categories"
}

fun NavGraphBuilder.catalogNavGraph(navController: NavController) {
    navigation(
        startDestination = CatalogNavigation.CATEGORIES_ROUTE,
        route = GlobalNavigation.CATALOG_ROUTE
    ) {
        composable(CatalogNavigation.CATEGORIES_ROUTE) {
            CategoriesRoute()
        }
    }
}
