package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.data.UserProvider

data class UserSerializer(
    //This data class will simulate the API Serializer.
    //It does not have the @json annotation because it will only be used to test the mappers.
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
)