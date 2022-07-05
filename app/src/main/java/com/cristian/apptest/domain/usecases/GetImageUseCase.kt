package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository

class GetImageUseCase {
    private val userRepository = UserRepository()
    suspend operator fun invoke(id: Int) = userRepository.getImage(id)
}