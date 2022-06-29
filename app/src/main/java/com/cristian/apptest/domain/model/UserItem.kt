package com.cristian.apptest.domain.model

import com.cristian.apptest.data.model.AddressModel
import com.cristian.apptest.data.model.CompanyModel
import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel


data class UserItem(
    val id: Int,
    val name: String,
    val email: String,
    val address: AddressItem,
    val phone: String,
    val website: String,
    val company: CompanyItem,
    val image: ImageItem
)
