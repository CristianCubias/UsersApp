package com.cristian.apptest.domain.usecases.di

import androidx.lifecycle.ViewModel
import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
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


    //Passing the UserRepository instance to the GetImagesFromLocalUseCase constructor
    @Provides
    @Singleton
    fun provideGetImagesFromLocalUseCase(userRepository: UserRepository) =
        GetImagesFromLocalUseCase(userRepository)

    //Passing the UserRepository instance to the GetImageFromLocalUseCase constructor
    @Provides
    @Singleton
    fun provideGetImageFromLocalUseCase(userRepository: UserRepository) =
        GetImageFromLocalUseCase(userRepository)

    //Passing the UserRepository instance to the InsertUserIntoDatabaseUseCase constructor
    @Provides
    @Singleton
    fun provideInsertUserIntoDatabaseUseCase(userRepository: UserRepository) =
        InsertUserIntoDatabaseUseCase(userRepository)

    //Passing the UserRepository instance to the InsertImageIntoDatabaseUseCase constructor
    @Provides
    @Singleton
    fun provideInsertImageIntoDatabaseUseCase(userRepository: UserRepository) =
        InsertImageIntoDatabaseUseCase(userRepository)
}