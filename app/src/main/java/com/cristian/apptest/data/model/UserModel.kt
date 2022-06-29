package com.cristian.apptest.data.model
data class UserModel (
    val id: Int,
    val name: String,
    val email: String,
    val address: AddressModel,
    val phone: String,
    val website: String,
    val company: CompanyModel
)