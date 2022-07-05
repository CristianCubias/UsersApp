package com.cristian.apptest.data

import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.requestmanager.RemoteDataSourceImp

class UserRepository() {
    private val remoteDataSource = RemoteDataSourceImp()
    //This function is used to get the users list from the API
    suspend fun getUsers(): List<UserModel> {
        return remoteDataSource.getUsers()
    }

    //This function is used to get the individual user from the API
    suspend fun getUser(id: Int): UserModel {
        return remoteDataSource.getUser(id)
    }

    //This function is used to get the images from the API
    suspend fun getImages(): List<ImageModel> {
        return remoteDataSource.getImages()
    }

    //This function is used to get the individual image from the API
    suspend fun getImage(id: Int): ImageModel {
        return remoteDataSource.getImage(id)
    }

    //This function is used to assign the image to the user
    suspend fun assignImage(userList: List<UserModel>, imageList: List<ImageModel>): List<UserModel> {
        return remoteDataSource.assignImageToUser(userList, imageList)
    }
}