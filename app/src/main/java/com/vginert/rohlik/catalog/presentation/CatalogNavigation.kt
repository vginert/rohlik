package com.vginert.rohlik.catalog.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.CATEGORIES_ROUTE
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.PRODUCTS_ROUTE
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.PRODUCTS_ROUTE_CATEGORY_ID_KEY
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.PRODUCT_DETAILS_ROUTE
import com.vginert.rohlik.catalog.presentation.CatalogNavigation.PRODUCT_DETAILS_ROUTE_PRODUCT_ID_KEY
import com.vginert.rohlik.catalog.presentation.categories.CategoriesNavigator
import com.vginert.rohlik.catalog.presentation.categories.CategoriesRoute
import com.vginert.rohlik.catalog.presentation.product_details.ProductDetailsRoute
import com.vginert.rohlik.catalog.presentation.products.ProductsNavigator
import com.vginert.rohlik.catalog.presentation.products.ProductsRoute
import com.vginert.rohlik.shared.presentation.navigation.GlobalNavigation.CATALOG_ROUTE

object CatalogNavigation {
    const val CATEGORIES_ROUTE = "catalog_categories"
    const val PRODUCTS_ROUTE = "catalog_products"
    const val PRODUCTS_ROUTE_CATEGORY_ID_KEY = "categoryId"
    const val PRODUCT_DETAILS_ROUTE = "catalog_product_details"
    const val PRODUCT_DETAILS_ROUTE_PRODUCT_ID_KEY = "productId"
}

fun NavGraphBuilder.catalogNavGraph(navController: NavController) {
    navigation(
        startDestination = CATEGORIES_ROUTE,
        route = CATALOG_ROUTE
    ) {
        composable(CATEGORIES_ROUTE) {
            CategoriesRoute(navigator = CategoriesNavigator(navController))
        }
        composable(
            route = "$PRODUCTS_ROUTE/{${PRODUCTS_ROUTE_CATEGORY_ID_KEY}}",
            arguments = listOf(
                navArgument(PRODUCTS_ROUTE_CATEGORY_ID_KEY) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString(PRODUCTS_ROUTE_CATEGORY_ID_KEY)
                ?: throw IllegalArgumentException("Category id is mandatory in products screen")
            ProductsRoute(
                categoryId = categoryId,
                navigator = ProductsNavigator(navController)
            )
        }
        composable(
            route = "$PRODUCT_DETAILS_ROUTE/{${PRODUCT_DETAILS_ROUTE_PRODUCT_ID_KEY}}",
            arguments = listOf(
                navArgument(PRODUCT_DETAILS_ROUTE_PRODUCT_ID_KEY) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString(PRODUCT_DETAILS_ROUTE_PRODUCT_ID_KEY)
                ?: throw IllegalArgumentException("Product id is mandatory in product details screen")
            ProductDetailsRoute(
                productId = productId,
            )
        }
    }
}
