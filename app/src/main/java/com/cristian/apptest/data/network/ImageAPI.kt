package com.cristian.apptest.data.network

import com.cristian.apptest.data.model.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageAPI {
    @Headers("Accept: application/json")
    @GET("/v2/list?page=2&limit=10")
    suspend fun getImages(): Response<List<ImageModel>>
}