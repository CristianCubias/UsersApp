package com.cristian.apptest.data.database.entities

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.cristian.apptest.data.model.AddressModel
import com.cristian.apptest.data.model.CompanyModel
import com.cristian.apptest.data.model.ImageModel

//This entity combines the data from the two models: UserModel and ImageModel in one entity
@Entity(tableName = "users_table", primaryKeys = ["id"])
data class UserEntity (
    @ColumnInfo(name = "id")        val id: Int,
    @ColumnInfo(name = "name")      val name: String,
    @ColumnInfo(name = "email")     val email: String,
    @ColumnInfo(name = "address")   val address: AddressModel,
    @ColumnInfo(name = "phone")     val phone: String,
    @ColumnInfo(name = "website")   val website: String,
    @ColumnInfo(name = "company")   val company: CompanyModel,
    @ColumnInfo(name = "user_img")  val image: ImageModel
    )