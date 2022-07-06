package com.cristian.apptest.framework.databasemanager.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey()
    val id: Int,
    val url: String,
    val title: String,
)