package com.cristian.apptest.data

import androidx.lifecycle.LiveData
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.requestmanager.RemoteDataSourceImp
import javax.inject.Inject

class UserRepository @Inject constructor(
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
    suspend fun getUsersFromLocal(): List<UserModel> {
        return localDataSource.getUsers()
    }

    //This function is used to get the individual user from the local database
    suspend fun getUserFromLocal(id: Int): UserModel {
        return localDataSource.getUser(id)
    }

    //This function is used to get the images from the local database
    suspend fun getImagesFromLocal(): List<ImageModel> {
        return localDataSource.getImages()
    }

    //This function is used to get the individual image from the local database
    suspend fun getImageFromLocal(id: Int): ImageModel {
        return localDataSource.getImage(id)
    }

    //This function is used to insert an user into the local database
    suspend fun insertUser(user: UserModel) {
        localDataSource.insertUser(user)
    }

    //This function is used to insert an image into the local database
    suspend fun insertImage(image: ImageModel) {
        localDataSource.insertImage(image)
    }



}