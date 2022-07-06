package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import javax.inject.Inject

class AssignImageToUserUseCase @Inject constructor(private val userRepository: UserRepository){
    suspend operator fun invoke(userList: List<UserModel>, imageList: List<ImageModel>) = userRepository.assignImage(userList, imageList)
}