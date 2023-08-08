package com.example.animations

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun AnimateAsStateAnimation(
    size: Dp
){
    Box(
        modifier = Modifier
            .animateContentSize()
            .width(size)
            .height(size)
    ) {
        Text(text = "AnimateAsState")
    }
}