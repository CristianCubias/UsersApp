package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.data.RemoteDataSource
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.requestmanager.utils.toDomain

class RemoteDataSourceImp (private val api: UsersAPI): RemoteDataSource {
    override suspend fun getUsers(): List<UserModel> {
        println("Calling API")
        val response = api.getUsers()
        //Error handling
        return if(response.isSuccessful){
            response.body()?.map { it.toDomain() } ?: emptyList()
        } else{
            emptyList()
        }
        //.toDomain() converts each item in the list from UserSerializer to UserModel
    }

    override suspend fun getImages(): List<ImageModel> {
        val response = api.getImages()
        //Error handling
        return if(response.isSuccessful){
            response.body()?.map { it.toDomain() } ?: emptyList()
        } else{
            emptyList()
        }
    }

    override suspend fun assignImageToUser(
        userList: List<UserModel>,
        imageList: List<ImageModel>
    ): List<UserModel> {
        return userList.map { user ->
            val image = imageList.find { it.id == user.id }?.url
            user.copy(imageUrl = image)
        }
    }
}