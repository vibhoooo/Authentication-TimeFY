package com.example.timefy.data.rules

import android.util.Log
import com.example.timefy.data.SignUpViewModel

object Validator {
    private val TAG = SignUpViewModel::class.simpleName
    fun validateFirstName(fName: String): ValidationResult {
        return ValidationResult(
            status = (!fName.isNullOrBlank() && fName.length >= 4)
        )
    }
    fun validateLastName(lName: String): ValidationResult {
        return ValidationResult(
            status = (!lName.isNullOrBlank())
        )
    }
    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            status = (!email.isNullOrBlank())
        )
    }
    fun validatePassword(password: String): ValidationResult {
        val isNullOrBlank = password.isNullOrBlank()
        val length = password.length
        Log.d(TAG, "isNullOrBlank: $isNullOrBlank, length: $length")
        return ValidationResult(
            status = (!password.isNullOrBlank() && password.length >= 4)
        )
    }
}
data class ValidationResult(
    val status: Boolean = false
)