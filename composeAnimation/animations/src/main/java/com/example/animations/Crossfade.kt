package com.example.animations

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// Crossfadeによるアニメーション
@Composable
fun CrossfadeAnimation(
    state: Boolean
) {
    Crossfade(
        targetState = state
    ) {
        when(it) {
            true -> Text(text = "Crossfade TRUE")
            false -> Text(text = "Crossfade FALSE")
        }
    }
}