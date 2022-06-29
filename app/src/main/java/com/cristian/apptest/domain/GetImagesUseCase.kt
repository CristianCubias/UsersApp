package com.cristian.apptest.domain

import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.data.model.ImageModel
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val userRepository: UserRepository)
{
    suspend fun getImages(): List<ImageModel>{
        return userRepository.getImageFromAPI()
    }
}