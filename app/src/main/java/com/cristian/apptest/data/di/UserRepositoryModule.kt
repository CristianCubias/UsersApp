package com.cristian.apptest.data.di

import com.cristian.apptest.data.RemoteDataSource
import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.framework.requestmanager.RemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryModule {

    //Module to provide all the dependencies needed for the UserRepository
    @Provides
    @Singleton
    fun provideUserRepository(remoteDataSource: RemoteDataSource): UserRepository {
        return UserRepository(remoteDataSource = remoteDataSource)
    }
}