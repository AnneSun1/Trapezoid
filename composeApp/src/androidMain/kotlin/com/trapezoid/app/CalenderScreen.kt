package com.trapezoid.app

import AddGoalScreen
import PostCard
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

import org.jetbrains.compose.ui.tooling.preview.Preview

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun CalenderScreen(navController: NavController) {

    Scaffold (
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(40.dp)
                            .padding(top = 16.dp),

                        contentDescription = "Back",
                    )
                }
            }
        },
        bottomBar = {
            NavBar(navController)
        },
        content =  { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)  // This automatically applies the correct padding
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
            ) {
                Calender()
            }
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .wrapContentSize()
                    .offset(x = 350.dp, y = 740.dp)
            ) {
                Icon(Icons.Filled.Add, "Check In")
            }
        }
    )


}