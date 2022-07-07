package com.cristian.apptest.domain.usecases

import com.cristian.apptest.data.UserRepository

class GetUserFromLocalUseCase (private val userRepository: UserRepository){
    operator fun invoke(id: Int) = userRepository.getUserFromLocal(id)
}