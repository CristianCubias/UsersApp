package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository

class GetUsersFromLocalUseCase (private val userRepository: UserRepository) {
    operator fun invoke() = userRepository.getUsersFromLocal()
}