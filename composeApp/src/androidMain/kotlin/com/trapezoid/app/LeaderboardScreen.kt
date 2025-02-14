package com.trapezoid.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LeaderboardScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(vertical = 50.dp, horizontal = 40.dp)) {
        IconButton(
            onClick = { navController.popBackStack() }
        ) {
            Icon(Icons.AutoMirrored.Default.KeyboardArrowLeft, "Back")
        }
        Text(
            text = "Leaderboard",
            fontSize = 40.sp,
            fontWeight = FontWeight.Black
        )
        PodiumView()
        LeaderboardList()
    }
}

@Composable
fun PodiumView() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        PodiumItem(position = 3, name = "London", score = 7894, height = 100.dp, Color(0xFF629AF5))
        PodiumItem(position = 1, name = "Paris", score = 10000, height = 200.dp, Color(0xFFEB5564))
        PodiumItem(position = 2, name = "Sydney", score = 9860, height = 150.dp, Color(0xFF56C674))
    }
}

@Composable
fun PodiumItem(position: Int, name: String, score: Int, height: Dp, color: Color) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            Icons.Rounded.AccountCircle,
            name,
            modifier = Modifier.size(60.dp),
            tint = Color(0xFFF1AE5C)
        )
        Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .width(70.dp)
                .padding(end = 2.dp)
                .height(height)
                .background(color, shape = RoundedCornerShape(10.dp, 10.dp, 0.dp,  0.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("$position", fontSize = 50.sp, fontWeight = FontWeight.Black)
        }
        Text("$score", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LeaderboardList() {
    val players = listOf(
        "Jill" to 4787,
        "Bob" to 2789,
        "Liz" to 2785,
        "John" to 2743,
        "Ron" to 1567,
        "David" to 754
    )

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(players.withIndex().toList()) { (index, player) ->
            LeaderboardRow(rank = index + 4, name = player.first, score = player.second)
        }
    }
}

@Composable
fun LeaderboardRow(rank: Int, name: String, score: Int) {
    Row (
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "$rank", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterVertically))
        Text(text = name, fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "$score", fontSize = 20.sp, textAlign = TextAlign.End, modifier = Modifier.align(Alignment.CenterVertically))
    }
    HorizontalDivider(thickness = 2.dp)
}