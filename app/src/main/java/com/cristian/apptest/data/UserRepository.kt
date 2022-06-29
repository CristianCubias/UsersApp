package com.cristian.apptest.data

import com.cristian.apptest.data.database.dao.UserDAO
import com.cristian.apptest.data.database.entities.UserEntity
import com.cristian.apptest.data.model.*
import com.cristian.apptest.data.network.RetrofitService
import com.cristian.apptest.domain.model.*
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val userDao: UserDAO) {

    //Function to get the user data from the API
    suspend fun getUsersFromAPI(): List<UserModel> {
        return retrofitService.getUsers()
    }

    //Function to get the image data from the API
    suspend fun getImageFromAPI(): List<ImageModel>{
        return retrofitService.getImages()
    }

    //Function to get the user data from the database
    suspend fun getUsersFromDB(): List<UserItem> {
        return emptyList()
        //return userDao.getUser()
    // TODO: Corregir. Tal vez implementar mappers?
    }

   suspend fun insertUser(user: List<UserEntity>) {
        userDao.insertUser(user)
    }

    //Function that combines the two APIs and returns a list of UserItem
    suspend fun getUsers(): List<UserItem> {
        return userDao.getUser().map {
            UserItem(
                it.id,
                it.name,
                it.email,
                AddressItem(it.address.street, it.address.suite, it.address.city, it.address.zipcode, GeoItem(it.address.geo.lat, it.address.geo.lng)),
                it.phone,
                it.website,
                CompanyItem(it.company.name, it.company.catchPhrase, it.company.bs),
                ImageItem(it.image.id, it.image.author, it.image.width, it.image.height, it.image.url, it.image.downloadUrl)
            )
        }
    }

    suspend fun combineLists(userList: List<UserModel>, imageList: List<ImageModel>): List<UserEntity> {
//        return userList.map {
//            UserEntity(
//                it.id,
//                it.name,
//                it.email,
//                AddressModel(it.address.street, it.address.suite, it.address.city, it.address.zipcode, GeoModel(it.address.geo.lat, it.address.geo.lng)),
//                it.phone,
//                it.website,
//                CompanyModel(it.company.name, it.company.catchPhrase, it.company.bs),
//                ImageModel(it.image.id, it.image.author, it.image.width, it.image.height, it.image.url, it.image.downloadUrl)
//            )
//        }
        return emptyList() // TODO: Corregir. Tal vez implementar mappers?
    }


}