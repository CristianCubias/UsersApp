package com.cristian.apptest.framework.databasemanager.utils

import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.databasemanager.entities.UserEntity

fun UserEntity.toDomain(): UserModel {
    return UserModel(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        address = this.address,
        imageUrl = this.imageUrl
    )
}

fun UserModel.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        address = this.address,
        imageUrl = this.imageUrl!!
    )
}