package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.domain.models.AddressModel
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel


fun UserSerializer.toDomain() =
    UserModel(
        id = id,
        name = name,
        username = username,
        email = email,
        //Working with nested JSON/Objects
        address = address.toDomain(),
        image_id = image_id,
    )

fun ImageSerializer.toDomain() =
    ImageModel(
        id = id,
        url = url,
        title = title,
    )

fun AddressSerializer.toDomain() =
    AddressModel(
        street = street,
        suite = suite,
        city = city,
    )