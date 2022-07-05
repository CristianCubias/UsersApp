package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.data.ImageProvider
import com.cristian.apptest.data.UserProvider

class FakeRetrofitAPI {
    suspend fun getUsers(): List<UserSerializer> {
        return UserProvider().usersResponse
    }

    suspend fun getUser(id: Int): UserSerializer {
        return UserProvider().usersResponse.first { it.id == id }
    }

    suspend fun getImages(): List<ImageSerializer>{
        return ImageProvider().imageResponse
    }

    suspend fun getImage(id: Int): ImageSerializer{
        return ImageProvider().imageResponse.first { it.id == id }
    }


}