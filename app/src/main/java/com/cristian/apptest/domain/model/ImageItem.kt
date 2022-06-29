package com.cristian.apptest.domain.model

data class ImageItem(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val downloadUrl: String
)