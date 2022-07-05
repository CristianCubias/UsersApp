package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository

class GetImagesUseCase {
    private val userRepository = UserRepository()
    suspend operator fun invoke() = userRepository.getImages()
}