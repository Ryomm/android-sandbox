package com.example.hiltandmultimodule.ui.theme.screens.articles

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltandmultimodule.data.remote.QiitaDataSourceRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

// viewModel
@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val dataSource: QiitaDataSourceRemote,
    private val scope: CoroutineScope
): ViewModel() {

    var viewState by mutableStateOf<ArticlesViewState>(
        ArticlesViewState(
            articles = listOf()
        )
    )
        private set

    fun fetchArticles() {
        viewModelScope.launch {
            val newData = scope.async {
                return@async dataSource.getArticles(1, 3)
            }.await()
            Log.d("hoge1", newData.toString())
            viewState.copy(articles = newData)
        }
    }
}