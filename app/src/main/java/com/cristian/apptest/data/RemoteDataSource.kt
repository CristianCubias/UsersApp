package com.cristian.apptest.data

import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel

interface RemoteDataSource{
    suspend fun getUsers(): List<UserModel>
    suspend fun getUser(id: Int): UserModel

    suspend fun getImages(): List<ImageModel>
    suspend fun getImage(id: Int): ImageModel

    suspend fun assignImageToUser(userList: List<UserModel>, imageList: List<ImageModel>): List<UserModel>
}