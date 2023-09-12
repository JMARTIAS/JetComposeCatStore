package com.example.jettest.presentation

sealed class Destinations(
    val route: String
) {
    object Dashboard: Destinations("dashboard")
    object DetailItem: Destinations("detailitem/?newText={newText}") {
        fun createRoute(
            newText: String) = "detailitem/?newText=$newText"
    }
}