package com.example.animations

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimationAPIAnimation(
    state: Float
) {
    Box(
        modifier = Modifier
            .width( state.dp)
            .height( state.dp)
    ) {
        Text(text = "Animation")
    }
}