package com.example.hiltandmultimodule.ui.theme

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hiltandmultimodule.ui.theme.screens.articles.ArticlesContainer
import com.example.hiltandmultimodule.ui.theme.screens.articles.ArticlesViewModel

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "articles",
    ) {
        composable("articles") {
            val viewModel = hiltViewModel<ArticlesViewModel>()
            ArticlesContainer(viewModel)
            Log.d("hoge", "hoge")
        }
    }
}