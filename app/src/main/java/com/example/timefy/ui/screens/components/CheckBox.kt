package com.example.timefy.ui.screens.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.timefy.ui.theme.Primary

@Composable
fun CheckBox(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var checkedState by remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState,
            onCheckedChange = {
                checkedState = !checkedState
            }
        )
        CheckBoxText(
            value = value,
            onTextSelected
        )
    }
}
@Composable
fun CheckBoxText(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyText = " Privacy Policy "
    val andText = " and "
    val termsText = " Terms of use "
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(
            style = SpanStyle(
                color = Primary
            )
        ){
            pushStringAnnotation(
                tag = privacyText,
                annotation = privacyText
            )
            append(privacyText)
        }
        append(andText)
        withStyle(
            style = SpanStyle(
                color = Primary
            )
        ){
            pushStringAnnotation(
                tag = termsText,
                annotation = termsText
            )
            append(termsText)
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableText", "{$span}")
                    if((span.item.trim() == termsText.trim()) || (span.item.trim() == privacyText.trim())) {
                         Log.d("ClickableText", "{$span}")
                         onTextSelected(span.item.trim())
                    }
                }
        }
    )
}