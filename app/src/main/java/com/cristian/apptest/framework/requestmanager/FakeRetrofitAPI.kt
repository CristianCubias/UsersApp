package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.data.UserProvider

class FakeRetrofitAPI {
    suspend fun getUsers(): List<UserSerializer> {
        return UserProvider().usersResponse
    }

    suspend fun getUser(id: Int): UserSerializer {
        return UserProvider().usersResponse.first { it.id == id }
    }
}