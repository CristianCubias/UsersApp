package com.cristian.apptest.data.di

import android.content.Context
import androidx.room.Room
import com.cristian.apptest.data.database.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DATABASE_NAME = "users.db"

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UsersDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(database: UsersDatabase) = database.getUsersDao()
}