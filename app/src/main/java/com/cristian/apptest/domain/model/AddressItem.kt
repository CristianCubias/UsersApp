package com.cristian.apptest.domain.model

import com.cristian.apptest.data.model.GeoModel

data class AddressItem (
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoItem
)
