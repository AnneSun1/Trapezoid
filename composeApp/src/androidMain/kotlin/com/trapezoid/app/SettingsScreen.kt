package com.trapezoid.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@androidx.compose.runtime.Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SettingsScreen(navController: NavController) {
    // TODO: Replace these with the actual settings with debouncing
    var notificationsEnabled by remember { mutableStateOf(true) }
//    var darkModeEnabled by remember { mutableStateOf(false) }
    var locationEnabled by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            Column () {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(Icons.AutoMirrored.Default.KeyboardArrowLeft, "Back")
                }

                Text(
                    "Settings",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Settings group: Preferences
            Text(
                text = "Preferences",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Change profile photo
            SettingsItem(
                title = "Change Profile Photo",
//                description = "Enable push notifications",
//                onCheckedChange = { notificationsEnabled = it } // TODO: Implement
            )

            // Change username
            SettingsItem(
                title = "Change Username",
//                description = "Enable push notifications",
//                onCheckedChange = { notificationsEnabled = it } // TODO: Implement
            )

            // Notification Settings
            SettingsSwitchItem(
                title = "Notifications",
                description = "Enable push notifications",
                checked = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it }
            )

            // Dark Mode Settings
//            SettingsSwitchItem(
//                title = "Dark Mode",
//                description = "Enable dark theme",
//                checked = darkModeEnabled,
//                onCheckedChange = { darkModeEnabled = it }
//            )

            // Location Settings
            SettingsSwitchItem(
                title = "Location Services",
                description = "Enable location tracking",
                checked = locationEnabled,
                onCheckedChange = { locationEnabled = it }
            )

            Spacer(modifier = Modifier.weight(1f))

            // Settings group: Account
            Text(
                text = "Account",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Profile Button
            SettingsButton(
                title = "Profile",
                description = "View and edit your profile",
                onClick = { /* Handle profile click */ }
            )

            // Privacy Policy Button
            SettingsButton(
                title = "Privacy Policy",
                description = "Read our privacy policy",
                onClick = { /* Handle privacy policy click */ }
            )

            // About Button
            SettingsButton(
                title = "About",
                description = "App version and information",
                onClick = { /* Handle about click */ }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Logout Button
            Button(
                onClick = { /* Handle logout */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Logout")
            }
        }
    }
}


@androidx.compose.runtime.Composable
fun SettingsItem(
    title: String,
    description: String? = null,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 4.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)

            if (!description.isNullOrEmpty()) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


@androidx.compose.runtime.Composable
fun SettingsSwitchItem(
    title: String,
    description: String? = null,
    checked: Boolean,
    onClick: () -> Unit = {},
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 4.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)

            if (!description.isNullOrEmpty()) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}


@Composable
fun SettingsButton(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    OutlinedCard(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = title, style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
