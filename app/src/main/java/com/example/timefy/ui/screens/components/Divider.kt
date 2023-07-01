package com.example.timefy.ui.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timefy.R
import com.example.timefy.ui.theme.grayColor
import com.example.timefy.ui.theme.textColor

@Composable
fun Divider() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = grayColor,
            thickness = 1.dp
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = stringResource(id = R.string.or),
            fontSize = 18.sp,
            color = textColor
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = grayColor,
            thickness = 1.dp
        )
    }
}