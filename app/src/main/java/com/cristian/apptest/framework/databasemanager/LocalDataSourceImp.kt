package com.cristian.apptest.framework.databasemanager

import com.cristian.apptest.data.LocalDataSource
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.databasemanager.utils.toDomain
import com.cristian.apptest.framework.databasemanager.utils.toEntity

class LocalDataSourceImp (private val database: UsersDatabase): LocalDataSource {
    override fun getUsers(): List<UserModel> {
        return database.userDao().getUsers().map { it.toDomain() }
    }

    override fun getUser(id: Int): UserModel {
        return database.userDao().getUser(id).toDomain()
    }

    override suspend fun insertUser(user: UserModel) {
        database.userDao().insertUser(user.toEntity())
    }
}