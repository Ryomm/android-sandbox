package com.example.hiltandmultimodule.models

// アプリ内で使う構造体
data class ArticleLocalModel (
    val title: String,
    val url: String,
    val user: UserLocalModel,
    val likesCount: Int
)

data class UserLocalModel(
    val name: String
)