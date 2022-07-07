package com.cristian.apptest.framework.requestmanager.utils

import com.squareup.moshi.Json

data class UserSerializer(
    @Json(name = "id")      val id: Int,
    @Json(name = "name")    val name: String,
    @Json(name = "username")val username: String,
    @Json(name = "email")   val email: String,
    @Json(name = "address") val address: AddressSerializer,
    val imageUrl: String?
)

data class ImageSerializer(
    @Json(name = "id")      val id: Int,
    @Json(name = "url")     val url: String,
    @Json(name = "title")   val title: String
)

data class AddressSerializer(
    @Json(name = "street")  val street: String,
    @Json(name = "suite")   val suite: String,
    @Json(name = "city")    val city: String
)