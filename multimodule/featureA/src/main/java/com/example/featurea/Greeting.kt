package com.example.featurea

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(
    message: String
) {
    Text(
        text = message,
        style = MaterialTheme.typography.headlineLarge
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting(message = "Hoge")
}