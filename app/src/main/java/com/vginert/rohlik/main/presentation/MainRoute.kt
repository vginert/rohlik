package com.vginert.rohlik.main.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainRoute(
    navController: NavHostController = rememberNavController(),
) {
    MainScreen(navController = navController)
}
