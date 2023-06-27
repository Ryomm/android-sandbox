package com.example.feature_articles

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.QiitaDataSourceRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val dataSource: QiitaDataSourceRemote
): ViewModel() {

    var viewState by mutableStateOf<ArticlesViewState>(
        ArticlesViewState(
            articles = listOf()
        )
    )
        private set

    fun fetchArticles() {
        viewModelScope.launch {
            val newData = dataSource.getArticles(1, 3)
            Log.d("hoge1", newData.toString())
            viewState = viewState.copy(articles = newData)
        }
    }
}