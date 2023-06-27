package com.example.data.remote

import com.example.data.models.ArticleLocalModel
import com.example.data.models.UserLocalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import javax.inject.Inject

// dataSource
class QiitaDataSourceRemoteImpl @Inject constructor(
    private val api: QiitaAPI,
    private val scope: CoroutineScope
): QiitaDataSourceRemote {
    override suspend fun getArticles(
        page: Int,
        parPage: Int
    ): List<ArticleLocalModel> {

        return scope.async {
            return@async api.getArticles(
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
        }.await()
    }
}