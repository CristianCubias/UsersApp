package com.cristian.apptest.domain.usecases.di

import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
//This module is necessary because it provides the dependencies for use cases
object UseCasesModule {
    //Passing the UserRepository instance to the AssignImageToUserUseCase constructor
    @Provides
    @Singleton
    fun provideAssignImageToUserUseCase(userRepository: UserRepository) =
        AssignImageToUserUseCase(userRepository)

    //Passing the UserRepository instance to the GetImagesUseCase constructor
    @Provides
    @Singleton
    fun provideGetImagesUseCase(userRepository: UserRepository) =
        GetImagesUseCase(userRepository)

    //Passing the UserRepository instance to the GetUsersUseCase constructor
    @Provides
    @Singleton
    fun provideUsersUseCase(userRepository: UserRepository) =
        GetUsersUseCase(userRepository)

    //Passing the UserRepository instance to the GetUsersFromLocalUseCase constructor
    @Provides
    @Singleton
    fun provideGetUsersFromLocalUseCase(userRepository: UserRepository) =
        GetUsersFromLocalUseCase(userRepository)

    //Passing the UserRepository instance to the GetUserFromLocalUseCase constructor
    @Provides
    @Singleton
    fun provideGetUserFromLocalUseCase(userRepository: UserRepository) =
        GetUserFromLocalUseCase(userRepository)

    //Passing the UserRepository instance to the InsertUserIntoDatabaseUseCase constructor
    @Provides
    @Singleton
    fun provideInsertUserIntoDatabaseUseCase(userRepository: UserRepository) =
        InsertUserIntoDatabaseUseCase(userRepository)
}