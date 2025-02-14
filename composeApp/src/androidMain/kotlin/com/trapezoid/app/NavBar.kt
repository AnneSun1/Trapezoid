package com.trapezoid.app
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavBar (navController: NavController) {
    val routes = listOf("Home", "Search", "Profile")
    val icons = listOf(Icons.Outlined.Home, Icons.Outlined.Search, Icons.Outlined.Person)
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Person)
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        routes.forEachIndexed { index, route ->
            NavigationBarItem(
                icon = {
                    Icon (
                        imageVector = if (routes.indexOf(currentRoute) == index) selectedIcons[index] else icons[index],
                        contentDescription = route
                    )
                },
                selected = index == routes.indexOf(currentRoute),
                onClick = {
                    navController.navigate(route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                    Log.d("Current Route", "Current route: $currentRoute")

                }// item holds the route names
            )
        }

    }
}