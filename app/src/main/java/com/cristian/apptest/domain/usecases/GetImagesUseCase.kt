package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getImages()
}