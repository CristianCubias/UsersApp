package com.cristian.apptest.framework.databasemanager.di

import com.cristian.apptest.data.LocalDataSource
import com.cristian.apptest.framework.databasemanager.LocalDataSourceImp
import com.cristian.apptest.framework.databasemanager.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(db: UsersDatabase): LocalDataSource {
        return LocalDataSourceImp(db)
    }
}