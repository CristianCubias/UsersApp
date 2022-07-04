package com.cristian.apptest.data

import com.cristian.apptest.domain.models.UserModel

interface RemoteDataSource{
    suspend fun getUsers(): List<UserModel>
    suspend fun getUser(id: Int): UserModel
}