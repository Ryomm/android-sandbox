package com.example.hiltandmultimodule.data.remote

import com.example.hiltandmultimodule.models.ArticleLocalModel
import com.example.hiltandmultimodule.models.UserLocalModel
import javax.inject.Inject

// dataSource
class QiitaDataSourceRemoteImpl @Inject constructor(
    private val api: QiitaAPI
): QiitaDataSourceRemote {
    override suspend fun getArticles(
        page: Int,
        parPage: Int
    ): List<ArticleLocalModel> {

        return api.getArticles(
            page = 1,
            perPage = 3
        ).map { article ->
            ArticleLocalModel(
                title = article.title,
                url = article.url,
                user = UserLocalModel(
                    name = article.user.name
                ),
                likesCount = article.likesCount
            )
        }
    }
}