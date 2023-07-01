package com.example.timefy.ui.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.timefy.R
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.timefy.ui.theme.Primary
import com.example.timefy.ui.theme.Shapes
import com.example.timefy.ui.theme.bgColor

@Composable
fun Input(
    labelValue: String,
    painterResource: Painter,
    onTextChangeSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {
    var textValue by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                Shapes.small
            ),
        label = {
            Text(
                text = labelValue
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            backgroundColor = bgColor
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        maxLines = 1,
        value = textValue,
        onValueChange = {
            textValue = it
            onTextChangeSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        isError = !errorStatus
    )
}
@Composable
fun InputPassword(
    labelValue: String,
    painterResource: Painter,
    onTextChangeSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {
    val localFocusManager = LocalFocusManager.current
    var password by remember {
        mutableStateOf("")
    }
    var visible by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                Shapes.small
            ),
        label = {
            Text(
                text = labelValue
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            backgroundColor = bgColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions(
        ) {
            localFocusManager.clearFocus()
        },
        value = password,
        onValueChange = {
            password = it
            onTextChangeSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(visible) {
                Icons.Filled.Visibility
            }
            else {
                Icons.Filled.VisibilityOff
            }
            val description = if(visible) {
                stringResource(id = R.string.show)
            }
            else {
                stringResource(id = R.string.hide)
            }
            IconButton(
                onClick = {
                    visible = !visible
                }
            ) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description
                )
            }
        },
        visualTransformation = if(visible) {
            VisualTransformation.None
        }
        else {
            PasswordVisualTransformation()
        },
        isError = !errorStatus
    )
}