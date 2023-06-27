package com.example.app_nia_catalog.ui

import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.data.models.ArticleLocalModel
import com.example.data.models.UserLocalModel
import com.example.feature_articles.ArticlesScreen
import com.example.feature_articles.HiltAndMultimoduleTheme

@Composable
fun Catalog() {
    HiltAndMultimoduleTheme {
        Surface {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = WindowInsets
                    .systemBars
                    .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                    .asPaddingValues(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    Text(
                        text = "NiA Catalog",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
                item {
                    val article: ArticleLocalModel = ArticleLocalModel(
                        title = "hoge title",
                        url = "https://ryomm.com",
                        user = UserLocalModel(
                            name = "Ryomm"
                        ),
                        likesCount = 100
                    )
                    ArticlesScreen(articles = listOf(article, article))
                }
            }
        }
    }
}