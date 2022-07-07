package com.cristian.apptest.framework.requestmanager.di

import com.cristian.apptest.data.RemoteDataSource
import com.cristian.apptest.framework.requestmanager.RemoteDataSourceImp
import com.cristian.apptest.framework.requestmanager.UsersAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(api: UsersAPI): RemoteDataSource =
        RemoteDataSourceImp(api)
}