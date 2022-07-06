package com.cristian.apptest.data

import androidx.lifecycle.LiveData
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel

interface LocalDataSource {
    fun getUsers(): List<UserModel>
    fun getUser(id: Int): UserModel
    fun insertUser(user: UserModel)
    fun getImages(): List<ImageModel>
    fun getImage(id: Int): ImageModel
    fun insertImage(image: ImageModel)
}