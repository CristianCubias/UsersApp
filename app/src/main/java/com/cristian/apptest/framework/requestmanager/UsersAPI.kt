package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.framework.requestmanager.utils.ImageSerializer
import com.cristian.apptest.framework.requestmanager.utils.UserSerializer
import retrofit2.Response
import retrofit2.http.GET

interface UsersAPI {
    //Users
    @GET("114fddc4-b422-4672-997e-9640d2175fe0")
    suspend fun getUsers(): Response<List<UserSerializer>>

    //Images
    @GET("1e517750-ac3e-4b2e-a495-a9bd2a6693fa")
    suspend fun getImages(): Response<List<ImageSerializer>>
}