package com.example.data.remote

import com.example.data.models.ArticleLocalModel

// dataSourceのインターフェース
interface QiitaDataSourceRemote {
    suspend fun getArticles(
        page: Int,
        parPage: Int
    ):List<ArticleLocalModel>
}