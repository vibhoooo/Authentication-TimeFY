package com.example.timefy.navigation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen() {
    object SignUpScreen: Screen()
    object TACScreen: Screen()
    object LogInScreen: Screen()
}
object Router {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)
    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
        Log.d("ClickableText", "{Navigating to: {$destination}}")
    }
}
