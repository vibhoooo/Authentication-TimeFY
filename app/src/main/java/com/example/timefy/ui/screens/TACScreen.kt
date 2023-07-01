package com.example.timefy.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timefy.R
import com.example.timefy.navigation.Router
import com.example.timefy.navigation.Screen
import com.example.timefy.navigation.SystemBackButtonHandler
import com.example.timefy.ui.screens.components.Header1

@Composable
fun TACScreen() {
    Log.d("ClickableText", "{TACScreen content displayed}")
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        Header1(
            value = stringResource(id = R.string.termsHeader)
        )
    }
    SystemBackButtonHandler {
        Log.d("ClickableText", "{Back button pressed}")
        Router.navigateTo(Screen.SignUpScreen)
    }
}
@Preview
@Composable
fun DefaultTACScreen() {
    TACScreen()
}