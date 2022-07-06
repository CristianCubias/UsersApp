package com.cristian.apptest.framework.requestmanager.di

import com.cristian.apptest.data.RemoteDataSource
import com.cristian.apptest.framework.requestmanager.FakeRetrofitAPI
import com.cristian.apptest.framework.requestmanager.RemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    //This function is used to provide the FakeRetrofitAPI instance to the RemoteDataSourceImp class
    @Provides
    @Singleton
    fun provideRemoteDataSource(api: FakeRetrofitAPI): RemoteDataSource =
        RemoteDataSourceImp(api)
}