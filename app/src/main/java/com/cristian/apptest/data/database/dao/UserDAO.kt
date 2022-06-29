package com.cristian.apptest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cristian.apptest.data.database.entities.UserEntity

@Dao
interface UserDAO {
    @Query("SELECT * FROM users_table")
    suspend fun getUser(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: List<UserEntity>)

    @Query("DELETE FROM users_table")
    suspend fun deleteUser()
}