package com.cristian.apptest.domain.usecases

import androidx.lifecycle.LiveData
import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.domain.models.UserModel
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getUsers()
}