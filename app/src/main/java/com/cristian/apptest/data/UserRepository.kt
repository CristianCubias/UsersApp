package com.cristian.apptest.data

import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel

class UserRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource) {
    //This function is used to get the users list from the API
    suspend fun getUsers(): List<UserModel> {
        return remoteDataSource.getUsers()
    }

    //This function is used to get the images from the API
    suspend fun getImages(): List<ImageModel> {
        return remoteDataSource.getImages()
    }

    //This function is used to assign the image to the user
    suspend fun assignImage(userList: List<UserModel>, imageList: List<ImageModel>): List<UserModel> {
        return remoteDataSource.assignImageToUser(userList, imageList)
    }

    //This function is used to get the users list from the local database
    fun getUsersFromLocal(): List<UserModel> {
        return localDataSource.getUsers()
    }

    //This function is used to get the individual user from the local database
    fun getUserFromLocal(id: Int): UserModel {
        return localDataSource.getUser(id)
    }

    //This function is used to insert an user into the local database
    suspend fun insertUser(user: UserModel) {
        localDataSource.insertUser(user)
    }
}