package com.example.jettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jettest.navigation.NavigationHost
import com.example.jettest.presentation.Banner
import com.example.jettest.presentation.Dashboard
import com.example.jettest.presentation.Destinations

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Contenedor principal de la actividad
            Box(modifier = Modifier)
            Column {
                Banner()
                NavigationHost()
                SectionDivider()
            }
            SectionDivider()
            // Definir la navegación y las composables
            val navHostController = rememberNavController()
            NavHost(
                navController = navHostController,
                startDestination = Destinations.Dashboard.route
            ) {
                composable(Destinations.Dashboard.route) {
/*                    Dashboard(
                        navController = navHostController,
                        navegarDetailItem = { itemId ->
                            navController.navigate(Destinations.DetalleItem.createRoute(itemId))
                        }
                    )*/
                }
            }
        }
    }
}

@Composable
fun SimpleComposable() {

}

@Composable
fun SectionDivider(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray) // Puedes personalizar el color del divisor
    )
}