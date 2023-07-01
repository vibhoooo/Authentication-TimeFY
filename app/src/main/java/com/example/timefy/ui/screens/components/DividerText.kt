package com.example.timefy.ui.screens.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timefy.ui.theme.Primary

@Composable
fun DividerText(signUp: Boolean = true, onTextSelected: (String) -> Unit) {
    val alreadyText = if(signUp) "Already have an account?" else "Don't have an account yet?"
    val loginText = if(signUp) "Login" else "Register"
    val annotatedString = buildAnnotatedString {
        append(alreadyText)
        withStyle(
            style = SpanStyle(
                color = Primary
            )
        ) {
            pushStringAnnotation(
                tag = loginText,
                annotation = loginText
            )
            append(loginText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableText", "{$span}")
                    if(span.item == loginText) {
                        Log.d("ClickableText", "{$span}")
                        onTextSelected(span.item.trim())
                    }
                }
        }
    )
}