package com.example.hiltandmultimodule.data.remote

import com.example.hiltandmultimodule.data.remote.model.ArticleRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

// Retrofitのインターフェース
interface QiitaAPI {
    @GET("/api/v2/items")
    suspend fun getArticles(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<ArticleRemoteModel>
}