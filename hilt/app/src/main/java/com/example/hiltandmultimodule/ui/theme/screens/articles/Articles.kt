package com.example.hiltandmultimodule.ui.theme.screens.articles

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hiltandmultimodule.models.ArticleLocalModel
import com.example.hiltandmultimodule.models.UserLocalModel
import com.example.hiltandmultimodule.ui.theme.HiltAndMultimoduleTheme

@Composable
fun ArticlesContainer(viewModel: ArticlesViewModel) {
    val viewState = viewModel.viewState

    LaunchedEffect(Unit){
        viewModel.fetchArticles()
        Log.d("hoge", viewState.articles.toString())
    }

    Log.d("hoge", viewState.articles.toString())

    ArticlesScreen(articles = viewState.articles)
}

@Composable
fun ArticlesScreen(
    articles: List<ArticleLocalModel>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        articles.forEach { article ->
            Article(article = article)
        }
    }
}

@Composable
fun Article(
    article: ArticleLocalModel
) {
    Card {
        Text(
            text = article.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = article.url,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = rememberVectorPainter(image = Icons.Filled.Favorite),
                contentDescription = null,
                modifier = Modifier.padding(2.dp)
            )
            Text(text = article.likesCount.toString(), style = MaterialTheme.typography.labelMedium)

            Spacer(modifier = Modifier.weight(1f))

            Text(text = article.user.name, style = MaterialTheme.typography.labelMedium, modifier = Modifier.padding(end = 0.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesPreview() {
    HiltAndMultimoduleTheme {
        ArticlesScreen(
            articles = listOf(
                ArticleLocalModel(
                    title = "ほげタイトル",
                    url = "https://qiita.com",
                    likesCount = 3,
                    user = UserLocalModel(
                        name = "Ryomm"
                    )
                ),
                ArticleLocalModel(
                    title = "ほげタイトル",
                    url = "https://qiita.com",
                    likesCount = 3,
                    user = UserLocalModel(
                        name = "Ryomm"
                    )
                )
            )
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    HiltAndMultimoduleTheme {
        Article(
            article = ArticleLocalModel(
                title = "ほげタイトル",
                url = "https://qiita.com",
                likesCount = 3,
                user = UserLocalModel(
                    name = "Ryomm"
                )
            )
        )
    }
}