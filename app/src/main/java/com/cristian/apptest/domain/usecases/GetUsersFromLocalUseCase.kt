package com.cristian.apptest.domain.usecases

import androidx.room.Insert
import com.cristian.apptest.data.UserRepository
import javax.inject.Inject

class GetUsersFromLocalUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getUsersFromLocal()
}