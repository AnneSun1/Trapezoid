package com.trapezoid.app

import PostCard
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(navController: NavController) {
//    val scrollState = rememberScrollState()
    Column() {
        Box() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Trapezoid",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(vertical = 25.dp, horizontal = 10.dp),

                    style = TextStyle(fontSize = 25.sp)
                )
                IconButton(onClick = { navController.navigate("Calender") }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(40.dp)
                            .padding(top = 16.dp),

                        contentDescription = "Calender",
                    )
                }
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp)
        ) {
            Text(
                text = "Check In",
                modifier = Modifier.padding(start = 25.dp, top = 20.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Column(
                modifier = Modifier.fillMaxSize().padding(bottom = 15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                androidx.compose.material.LinearProgressIndicator(
                    progress = 0.5f, // Fixed progress value, e.g., 50%
                    modifier = Modifier
                        .width(300.dp)
                        .height(8.dp),
                    color = Color.Black,
                    backgroundColor = Color.White
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            items(3) { _ ->
                Box(
                ) {
                    PostCard("Studying", "Anne")
                }
            }
        }
        NavBar(navController = navController)
    }
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .wrapContentSize()
                    .offset(x = 350.dp, y = 740.dp)
        ) {
                Icon(Icons.Filled.Check, "Check In")
            }





}

@Composable
fun LinearDeterminateIndicator(progress: Float, modifier: Modifier, color: Any, backgroundColor: Any) {

}
