package com.trapezoid.app.com.trapezoid.app

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.compose.ui.tooling.preview.Preview
import com.trapezoid.app.R


@androidx.compose.runtime.Composable
@Preview
fun GoalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Header section with fixed position
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Outdoor Running",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "May 1st, 2025 - July 20th, 2025",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // Scrollable content
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(100.dp)  // Space between items
            ) {
                items(30) { index ->
                    val number = (30 - index).toString()  // Counting down from 30 to 1
                    FloatingTrapezoid(
                        number = number,
                        yOffset = 0f,  // We don't need yOffset since LazyColumn handles vertical positioning
                        xOffset = if (index % 2 == 0) -60f else 60f,  // Alternating left and right
                        initialDelay = index * 100,  // Staggered animation
                        zIndex = (30 - index).toFloat()
                    )
                }
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun FloatingTrapezoid(
    number: String,
    yOffset: Float,
    xOffset: Float,
    initialDelay: Int,
    zIndex: Float
) {
    // Create infinite animation
    val infiniteTransition = rememberInfiniteTransition()

    // Animate vertical position
    val verticalOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, delayMillis = initialDelay),
            repeatMode = RepeatMode.Reverse
        )
    )

    val horizontalOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, delayMillis = initialDelay),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Animate scale
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, delayMillis = initialDelay),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .offset(
                x = (xOffset + horizontalOffset).dp,
                y = (yOffset + verticalOffset).dp
            )
            .scale(scale)
            .zIndex(zIndex)
    ) {
        // Trapezoid image
        Image(
            painter = painterResource(id = R.drawable.bluetrapezoid),
            contentDescription = "Trapezoid $number",
            modifier = Modifier
                .fillMaxWidth(0.6f)  // Made slightly smaller to fit better
                .aspectRatio(2f),
            contentScale = ContentScale.Fit
        )

        // Number on top
        Text(
            text = number,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .offset(y = (-8).dp)
        )
    }
}