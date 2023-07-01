package com.example.timefy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timefy.R
import com.example.timefy.data.SignUpViewModel
import com.example.timefy.data.UiEvents
import com.example.timefy.navigation.Router
import com.example.timefy.navigation.Screen
import com.example.timefy.navigation.SystemBackButtonHandler
import com.example.timefy.ui.screens.components.*

@Composable
fun LogInScreen(SignUpViewModel: SignUpViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header1(
                value = stringResource(id = R.string.login)
            )
            Header2(
                value = stringResource(id = R.string.welcome)
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Input(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.message),
                onTextChangeSelected = {
                    SignUpViewModel.onEvent(UiEvents.EmailChanged(it))
                },
                errorStatus = SignUpViewModel.signUpUIState.value.emailError
            )
            InputPassword(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.lock),
                onTextChangeSelected = {
                    SignUpViewModel.onEvent(UiEvents.PasswordChanged(it))
                },
                errorStatus = SignUpViewModel.signUpUIState.value.passwordError
            )
            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )
            ForgotPass(
                value = stringResource(id = R.string.forgot)
            )
            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )
            Button(
                value = stringResource(id = R.string.login),
                onButtonClicked = {
                    SignUpViewModel.onEvent(UiEvents.LoginButtonClicked)
                }
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Divider()
            DividerText(
                signUp = false,
                onTextSelected = {
                    Router.navigateTo(Screen.SignUpScreen)
                }
            )
        }
        SystemBackButtonHandler {
            Router.navigateTo(Screen.SignUpScreen)
        }
    }
}
@Preview
@Composable
fun DefaultLogInScreen() {
    LogInScreen()
}