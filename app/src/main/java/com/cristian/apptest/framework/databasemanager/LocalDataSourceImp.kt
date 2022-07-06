package com.cristian.apptest.framework.databasemanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.cristian.apptest.data.LocalDataSource
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.databasemanager.utils.toDomain
import com.cristian.apptest.framework.databasemanager.utils.toEntity

class LocalDataSourceImp constructor(private val database: UsersDatabase): LocalDataSource {
    override fun getUsers(): List<UserModel> {
        return database.userDao().getUsers().map { it.toDomain() }
    }

    override fun getUser(id: Int): UserModel {
        return database.userDao().getUser(id).toDomain()
    }

    override fun insertUser(user: UserModel) {
        database.userDao().insertUser(user.toEntity())
    }

    override fun getImages(): List<ImageModel> {
        return database.imageDao().getImages().map { it.toDomain() }
    }

    override fun getImage(id: Int): ImageModel {
        return database.imageDao().getImage(id).toDomain()
    }

    override fun insertImage(image: ImageModel) {
        database.imageDao().insertImage(image.toEntity())
    }
}