package com.cristian.apptest.data.network

import com.cristian.apptest.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserAPI {
    @Headers("Accept: application/json")
    @GET("/users")
    suspend fun getUsers(): Response<List<UserModel>>
}