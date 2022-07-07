package com.cristian.apptest.framework.databasemanager

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cristian.apptest.framework.databasemanager.daos.UsersDAO
import com.cristian.apptest.framework.databasemanager.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UsersDatabase: RoomDatabase() {
    abstract fun userDao(): UsersDAO
}