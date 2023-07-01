package com.example.timefy.app

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.timefy.navigation.Router
import com.example.timefy.navigation.Screen
import com.example.timefy.ui.screens.LogInScreen
import com.example.timefy.ui.screens.SignUpScreen
import com.example.timefy.ui.screens.TACScreen


@Composable
fun App() {
    Log.d("ClickableText", "{HMM_1}")
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(
            targetState = Router.currentScreen
        ) { currentState ->
            when(currentState.value) {
                is Screen.SignUpScreen -> {
                    Log.d("ClickableText", "{HMM_1}")
                    SignUpScreen()
                }
                is Screen.TACScreen -> {
                    Log.d("ClickableText", "{HMM_1}")
                    TACScreen()
                }
                is Screen.LogInScreen -> {
                    LogInScreen()
                }
            }
        }
    }
}
@Preview
@Composable
fun DefaultApp() {
    App()
}