package com.example.animations

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun Sample3(
    state: Transition<Float>
){
    val process by state.animateFloat(label = "progress") {
        it
    }
    val color by state.animateColor(label = "color") {
        if(it>=1.0f) MaterialTheme.colorScheme.primary else Color.LightGray
    }
    Button(
        onClick = {},
        modifier = Modifier
            .size(100.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(disabledContainerColor = color, containerColor = color),
        enabled = process>=1.0f,
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Next")
            CircularProgressIndicator(
                progress = process,
                modifier = Modifier
                    .size(100.dp),
            )
        }
    }
}
