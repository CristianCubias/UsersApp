package com.cristian.apptest.framework.databasemanager.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cristian.apptest.framework.databasemanager.entities.ImageEntity

@Dao
interface ImagesDAO {
    @Query("SELECT * FROM images")
    fun getImages(): List<ImageEntity>

    @Query("SELECT * FROM images WHERE id = :id")
    fun getImage(id: Int): ImageEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImage(image: ImageEntity)

    @Query("DELETE FROM images")
    fun deleteAll()

}