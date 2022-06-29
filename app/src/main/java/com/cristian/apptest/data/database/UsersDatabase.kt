package com.cristian.apptest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cristian.apptest.data.database.dao.UserDAO
import com.cristian.apptest.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UsersDatabase: RoomDatabase() {
    abstract fun getUsersDao(): UserDAO
}