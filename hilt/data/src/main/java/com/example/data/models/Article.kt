package com.example.data.models

// アプリ内で使う構造体
data class ArticleLocalModel (
    val title: String,
    val url: String,
    val user: UserLocalModel,
    val likesCount: Int
)