package com.example.jettest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.jettest.presentation.Dashboard
import com.example.jettest.presentation.Destinations
import com.example.jettest.presentation.DetailItem


@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Dashboard.route) {
        composable(Destinations.Dashboard.route) {
            Dashboard(
                navegarDetailItem = { newText ->
                    navController.navigate("${Destinations.DetailItem.route}?newText=$newText")
                }
            )
        }

        composable(
            route = "${Destinations.DetailItem.route}?newText={newText}",
            arguments = listOf(navArgument("newText") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val newText = navBackStackEntry.arguments?.getString("newText") ?: "Pantalla 2"

            DetailItem(newText) {
                // Lambda para manejar la navegación de vuelta a Pantalla1
                navController.navigateUp()
            }
        }
    }
}