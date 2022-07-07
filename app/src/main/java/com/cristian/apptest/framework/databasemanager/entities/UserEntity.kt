package com.cristian.apptest.framework.databasemanager.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cristian.apptest.domain.models.AddressModel

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    @Embedded
    val address: AddressModel,
    var imageUrl: String,
)