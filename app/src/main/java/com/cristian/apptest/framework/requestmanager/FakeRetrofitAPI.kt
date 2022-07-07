package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.data.ImageProvider
import com.cristian.apptest.data.UserProvider
import com.cristian.apptest.framework.requestmanager.utils.ImageSerializer
import com.cristian.apptest.framework.requestmanager.utils.UserSerializer
import javax.inject.Inject

//This class is implemented temporarily to avoid the dependency errors,
// but it will be replaced by a real implementation
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

    suspend fun getImage(id: Int): ImageSerializer {
        return ImageProvider().imageResponse.first { it.id == id }
    }


}