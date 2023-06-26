package com.example.hiltandmultimodule.data.remote

import com.example.hiltandmultimodule.models.ArticleLocalModel

// dataSourceのインターフェース
interface QiitaDataSourceRemote {
    suspend fun getArticles(
        page: Int,
        parPage: Int
    ):List<ArticleLocalModel>
}