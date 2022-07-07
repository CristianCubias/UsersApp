package com.cristian.apptest.data

import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel

interface LocalDataSource {
    fun getUsers(): List<UserModel>
    fun getUser(id: Int): UserModel
    suspend fun insertUser(user: UserModel)
}