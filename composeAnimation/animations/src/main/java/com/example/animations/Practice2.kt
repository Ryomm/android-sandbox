package com.example.animations

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Sample2(
    state: Transition<Float>
){
    val process by state.animateFloat(label = "progress") {
        it
    }
    val color by state.animateColor(label = "color") {
        if(it>=1.0f) Color.Red else MaterialTheme.colorScheme.secondary
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp),
            progress = process,
            strokeWidth = 4.dp,
            color = color
        )
        Text(
            text = (process*100).toInt().toString()+"%"
        )
    }
}