package com.example.timefy.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.timefy.data.rules.Validator

class SignUpViewModel: ViewModel() {
    private val TAG = SignUpViewModel::class.simpleName
    var signUpUIState = mutableStateOf(SignUpUIState())
    fun onEvent(event: UiEvents) {
        when(event) {
            is UiEvents.FirstNameChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    firstName = event.firstName
                )
                validateDataWithRules()
                printState()
            }
            is UiEvents.LastNameChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    lastName = event.lastName
                )
                validateDataWithRules()
                printState()
            }
            is UiEvents.EmailChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    email = event.email
                )
                validateDataWithRules()
                printState()
            }
            is UiEvents.PasswordChanged -> {
                Log.d(TAG, "PasswordChanged: ${event.password}")
                signUpUIState.value = signUpUIState.value.copy(
                    password = event.password
                )
                validateDataWithRules()
                printState()
            }
            is UiEvents.RegisterButtonClicked -> {
                signUp()
                validateDataWithRules()
            }
            is UiEvents.LoginButtonClicked -> {
                logIn()
                validateDataWithRules()
            }
        }
    }
    private fun signUp() {
        Log.d(TAG, "Inside signUp()")
        printState()
    }
    private fun logIn() {
        Log.d(TAG, "Inside logIn()")
        printState()
    }
    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(
            fName = signUpUIState.value.firstName
        )
        val lNameResult = Validator.validateLastName(
            lName = signUpUIState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = signUpUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = signUpUIState.value.password
        )
        Log.d(TAG, "Inside validateDataWithRules()")
        Log.d(TAG, "fNameResult = $fNameResult")
        Log.d(TAG, "lNameResult = $lNameResult")
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")
        signUpUIState.value = signUpUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )
    }
    private fun printState() {
        Log.d(TAG, "Inside printState()")
        Log.d(TAG, signUpUIState.value.toString())
    }
}
