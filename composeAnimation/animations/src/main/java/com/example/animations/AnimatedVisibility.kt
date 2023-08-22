package com.example.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

// AnimatedVisibilityによるアニメーション
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Sample(
    visible: Boolean
) {
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(initialScale = 1f) + fadeIn(initialAlpha = 0.3f) + expandIn(),
        exit = scaleOut() + fadeOut() + shrinkOut(),
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .animateContentSize()
                .size(100.dp)
                .clip(CircleShape)
                .background(color = Color.White)
                .border(width = 1.dp, shape = CircleShape, color = Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "・x・")
        }
    }
}