package com.cristian.apptest.framework.databasemanager.di

import android.content.Context
import androidx.room.Room
import com.cristian.apptest.framework.databasemanager.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): UsersDatabase {
        return Room.databaseBuilder(
            context,
            UsersDatabase::class.java,
            "users_database"
        ).build()
    }
}