package com.cristian.apptest.data

import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.requestmanager.RemoteDataSourceImp

class UserRepository() {
    private val remoteDataSource = RemoteDataSourceImp()
    suspend fun getUsers(): List<UserModel> {
        return remoteDataSource.getUsers()
    }
    suspend fun getUser(id: Int): UserModel {
        return remoteDataSource.getUser(id)
    }
}