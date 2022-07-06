package com.cristian.apptest.framework.databasemanager.utils

import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.framework.databasemanager.entities.ImageEntity
import com.cristian.apptest.framework.databasemanager.entities.UserEntity

fun UserEntity.toDomain(): UserModel {
    return UserModel(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        address = this.address,
        image_id = this.image_id
    )
}

fun UserModel.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        address = this.address,
        image_id = this.image_id!!
    )
}

fun ImageEntity.toDomain(): ImageModel {
    return ImageModel(
        id = this.id,
        url = this.url,
        title = this.title,
    )
}

fun ImageModel.toEntity(): ImageEntity {
    return ImageEntity(
        id = this.id,
        url = this.url,
        title = this.title,
    )
}