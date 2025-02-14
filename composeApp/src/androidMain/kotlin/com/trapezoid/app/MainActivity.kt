package com.trapezoid.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainApp()  // Changed name to be more specific
        }
    }
}

@Composable
fun MainApp() {
    App()
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    MainApp()
}