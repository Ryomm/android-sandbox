package com.example.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// パース用の構造体
@Serializable
data class ArticleRemoteModel(
    val title: String,
    val url: String,
    val user: UserRemoteModel,
    @SerialName(value = "likes_count")
    val likesCount: Int = 0
)

@Serializable
data class UserRemoteModel(
    val name: String
)