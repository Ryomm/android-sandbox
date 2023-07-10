package com.example.data.di

import com.example.data.remote.QiitaDataSourceRemote
import com.example.data.remote.QiitaDataSourceRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindQiitaDataSource(impl: QiitaDataSourceRemoteImpl): QiitaDataSourceRemote
}