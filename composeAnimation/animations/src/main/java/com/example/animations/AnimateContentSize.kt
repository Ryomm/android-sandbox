package com.example.animations

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContentSizeAnimation(
    state: Boolean
) {
    Box(
        modifier = Modifier
            .animateContentSize()
            .width( if(state) 350.dp else 150.dp)
            .height( if(state) 100.dp else 50.dp)
    ) {
        Text(text = "AnimateContentSize")
    }
}