package com.example.animations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RememberInfiniteTransitionAnimation(
    state: Float
) {
    Box(
        Modifier
            .rotate(state)
            .width(50.dp)
            .height(50.dp)
            .background(
                color = Color.LightGray
            )
    ){
        Text(text = "rememberInfiniteTransition")
    }
}