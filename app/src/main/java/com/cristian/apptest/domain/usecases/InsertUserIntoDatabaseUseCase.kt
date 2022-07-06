package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.domain.models.UserModel
import javax.inject.Inject

class InsertUserIntoDatabaseUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: UserModel) = userRepository.insertUser(user)
}