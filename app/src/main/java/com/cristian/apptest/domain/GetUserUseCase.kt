package com.cristian.apptest.domain

import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel
import com.cristian.apptest.domain.model.UserItem
import org.checkerframework.framework.qual.LiteralKind
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository)
{
    suspend fun getUser(): List<UserModel>{
        return userRepository.getUsersFromAPI()
    }
}