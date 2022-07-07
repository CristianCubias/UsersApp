package com.cristian.apptest.framework.databasemanager.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cristian.apptest.framework.databasemanager.entities.UserEntity

@Dao
interface UsersDAO {
    @Query("SELECT * FROM users")
    fun getUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("DELETE FROM users")
    fun deleteAll()

}