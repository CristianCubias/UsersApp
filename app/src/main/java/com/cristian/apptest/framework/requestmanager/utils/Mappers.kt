package com.cristian.apptest.framework.requestmanager.utils

import com.cristian.apptest.domain.models.AddressModel
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel


fun UserSerializer.toDomain() =
    UserModel(
        id = id,
        name = name,
        username = username,
        email = email,
        address = address.toDomain(),
        imageUrl = imageUrl,
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