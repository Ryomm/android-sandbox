package com.example.hiltandmultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hiltandmultimodule.ui.theme.HiltAndMultimoduleTheme
import com.example.hiltandmultimodule.ui.theme.screens.articles.ArticlesContainer
import com.example.hiltandmultimodule.ui.theme.screens.articles.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltAndMultimoduleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel =hiltViewModel< ArticlesViewModel>()
                    ArticlesContainer(viewModel)
                }
            }
        }
    }
}


