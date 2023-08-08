package com.example.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text


@Composable
fun AnimatedVisibilityAnimation(
    visible: Boolean
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(initialAlpha = 0.1f),
        exit = fadeOut(animationSpec = tween(durationMillis = 250))
    ) {
        Text(text = "AnimatedVisibility")
    }
}