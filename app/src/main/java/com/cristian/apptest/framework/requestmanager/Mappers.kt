package com.cristian.apptest.framework.requestmanager

import com.cristian.apptest.domain.models.UserModel


fun UserSerializer.toDomain() = UserModel(
    id = id,
    name = name,
    username = username,
    email = email,
)