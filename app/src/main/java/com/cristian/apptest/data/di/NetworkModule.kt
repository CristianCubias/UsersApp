package com.cristian.apptest.data.di

import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel
import com.cristian.apptest.data.network.ImageAPI
import com.cristian.apptest.data.network.RetrofitService
import com.cristian.apptest.data.network.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.net.URL
import java.nio.InvalidMarkException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //Retrofit module
    @Singleton
    @Provides
    fun provideRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    suspend fun provideUsers(retrofit: Retrofit): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }

    @Singleton
    @Provides
    suspend fun provideImages(retrofit: Retrofit): ImageAPI {
        return retrofit.create(ImageAPI::class.java)
    }
}