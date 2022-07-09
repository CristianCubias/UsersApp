package com.cristian.apptest.data

import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource) {
    //This function is used to get the users list from the API
    suspend fun getUsers(): Flow<List<UserModel>> = flow { emit(remoteDataSource.getUsers()) }

    //This function is used to get the images from the API
    suspend fun getImages(): Flow<List<ImageModel>> = flow { emit(remoteDataSource.getImages()) }

    //This function is used to assign the image to the user
    suspend fun assignImage(userList: List<UserModel>, imageList: List<ImageModel>): List<UserModel> {
        return remoteDataSource.assignImageToUser(userList, imageList)
    }

    //This function is used to get the users list from the local database
    fun getUsersFromLocal(): Flow<List<UserModel>> = flow { emit(localDataSource.getUsers()) }

    //This function is used to get the individual user from the local database
    fun getUserFromLocal(id: Int): Flow<UserModel> = flow { emit(localDataSource.getUser(id)) }

    //This function is used to insert an user into the local database
    suspend fun insertUser(user: UserModel) {
        localDataSource.insertUser(user)
    }
}