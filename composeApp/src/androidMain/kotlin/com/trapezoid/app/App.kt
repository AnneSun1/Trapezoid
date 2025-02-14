package com.trapezoid.app

import AddGoalScreen
import SearchScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import trapezoid.composeapp.generated.resources.Res
import trapezoid.composeapp.generated.resources.compose_multiplatform
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview
fun App() {
    val navController = rememberNavController()
    NavHost (
        navController = navController,
        startDestination = "Home"
    ) {
        composable("Calender") { CalenderScreen(navController) }
        composable("Home" ) {HomeScreen(navController)}
        composable("Profile") { ProfileScreen(navController) }
        composable("Friends") { FriendsScreen(navController) }
        composable("Leaderboard") { LeaderboardScreen(navController) }
        composable("Search") { SearchScreen(navController) }
        composable( "Settings") { SettingsScreen(navController) }
        composable( "Add Goal") { AddGoalScreen(navController) }

    }
}