package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.domain.models.ImageModel
import javax.inject.Inject

class InsertImageIntoDatabaseUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(image: ImageModel) = userRepository.insertImage(image)
}