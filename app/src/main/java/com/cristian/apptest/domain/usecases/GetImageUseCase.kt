package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(id: Int) = userRepository.getImage(id)
}