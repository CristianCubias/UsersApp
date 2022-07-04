package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.data.RemoteDataSource
import com.cristian.apptest.domain.models.UserModel

class RemoteDataSourceImp: RemoteDataSource {
    private val api = FakeRetrofitAPI()
    override suspend fun getUsers(): List<UserModel> {
        val response = api.getUsers()
        return response.map { it.toDomain() }
        //.toDomain() converts each item in the list from UserSerializer to UserModel
    }

    override suspend fun getUser(id: Int): UserModel {
        val response = api.getUser(id)
        return response.toDomain()
    }
}