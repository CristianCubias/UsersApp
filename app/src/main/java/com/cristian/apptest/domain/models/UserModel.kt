package com.cristian.apptest.domain.models

data class UserModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    //Working with nested JSON/Objects
    val address: AddressModel,
    var image_id: Int?,
)