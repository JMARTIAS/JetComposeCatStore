package com.example.jettest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.jettest.presentation.Destinations
import com.example.jettest.presentation.Pantalla1
import com.example.jettest.presentation.Pantalla2


@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Pantalla1.route) {
        composable(Destinations.Pantalla1.route) {
            Pantalla1(
                navegarPantalla2 = { newText ->
                    navController.navigate("${Destinations.Pantalla2.route}?newText=$newText")
                }
            )
        }

        composable(
            route = "${Destinations.Pantalla2.route}?newText={newText}",
            arguments = listOf(navArgument("newText") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val newText = navBackStackEntry.arguments?.getString("newText") ?: "Pantalla 2"

            Pantalla2(newText) {
                // Lambda para manejar la navegación de vuelta a Pantalla1
                navController.navigateUp()
            }
        }
    }
}