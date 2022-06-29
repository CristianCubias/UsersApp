package com.cristian.apptest.data.network

import com.cristian.apptest.data.di.NetworkModule
import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitService @Inject constructor(
    private val retrofitInstance: NetworkModule) {

    suspend fun getUsers(): List<UserModel> {
        return withContext(Dispatchers.IO){
            retrofitInstance.provideUsers(
                retrofitInstance.provideRetrofit("https://jsonplaceholder.typicode.com/users/"))
                .getUsers().body() ?: emptyList()
        //retrofitInstance.provideUsers(ins).getUsers().body() ?: emptyList()
        }
    }

    suspend fun getImages(): List<ImageModel> {
        return withContext(Dispatchers.IO){
            retrofitInstance.provideImages(
                retrofitInstance.provideRetrofit("https://picsum.photos/"))
                .getImages().body() ?: emptyList()
        }
    }
}