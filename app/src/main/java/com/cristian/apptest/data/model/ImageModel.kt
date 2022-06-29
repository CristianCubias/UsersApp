package com.cristian.apptest.data.model

import com.squareup.moshi.Json

data class ImageModel(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @field:Json(name = "download_url") val downloadUrl: String
)