package com.trapezoid.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsRun
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Leaderboard
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Bedtime
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
@Preview
fun ProfileScreen(navController: NavController) {
    Scaffold (
        bottomBar = { NavBar(navController) },
        content = {
            Column(
                modifier = Modifier.fillMaxSize().padding(vertical = 50.dp, horizontal = 40.dp),
                verticalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                ProfileContent(navController)
                GoalsList()

            }
        }
    )
}

@Composable
fun ProfileContent(navController: NavController) {
    Row(
        modifier = Modifier.height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier.size(90.dp).clip(CircleShape).background(Color.Black),
        )
        Column (
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                "Alex Smith",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "alex@username",
                fontSize = 15.sp
            )
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                IconButton(
                    onClick = { navController.navigate("Friends") }
                ) { Icon(Icons.Outlined.Groups, "Your Friends") }

                IconButton(
                    onClick = { navController.navigate("Leaderboard") }
                ) { Icon(Icons.Outlined.Leaderboard, "Leaderboard") }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { navController.navigate("Settings") }
        ) {
            Icon(Icons.Outlined.Settings, "Settings")
        }
    }
}

@Composable
fun GoalsList() {
    Column {
        Text(
            "Goals",
            fontSize = 40.sp,
            fontWeight = FontWeight.Black
        )
        Column {
            Row (
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(Icons.AutoMirrored.Rounded.DirectionsRun, "outdoor running", Modifier.size(35.dp))
                Text("Outdoor Running", fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterVertically))
            }
            HorizontalDivider(thickness = 2.dp)

            Row (
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(Icons.Rounded.Bedtime, "consistent sleep schedule", Modifier.size(35.dp))
                Text("Maintain a Consistent Sleep Schedule", fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterVertically))
            }
            HorizontalDivider(thickness = 2.dp)

            Row (
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(Icons.Rounded.Code, "master frontend", Modifier.size(35.dp))
                Text("Master Frontend Web Development", fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterVertically))
            }
            HorizontalDivider(thickness = 2.dp)
        }
    }
}