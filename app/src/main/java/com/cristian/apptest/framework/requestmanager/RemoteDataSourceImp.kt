package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.data.RemoteDataSource
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.requestmanager.utils.toDomain

class RemoteDataSourceImp constructor(private val api: FakeRetrofitAPI): RemoteDataSource {
    override suspend fun getUsers(): List<UserModel> {
        val response = api.getUsers()
        return response.map { it.toDomain() }
        //.toDomain() converts each item in the list from UserSerializer to UserModel
    }

    override suspend fun getUser(id: Int): UserModel {
        val response = api.getUser(id)
        return response.toDomain()
    }

    override suspend fun getImages(): List<ImageModel> {
        val response = api.getImages()
        return response.map { it.toDomain() }
    }

    override suspend fun getImage(id: Int): ImageModel {
        val response = api.getImage(id)
        return response.toDomain()
    }

    override suspend fun assignImageToUser(
        userList: List<UserModel>,
        imageList: List<ImageModel>
    ): List<UserModel> {
        return userList.map { user ->
            val image = imageList.find { it.id == user.id }?.id
            user.copy(image_id = image)
        }
    }
}