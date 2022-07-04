package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.*
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.domain.usecases.GetUserUseCase
import com.cristian.apptest.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(): ViewModel() {
    val _users by lazy { MutableLiveData<List<UserModel>>() }
    val _user by lazy { MutableLiveData<UserModel>() }
    val users: LiveData<List<UserModel>> get() = _users
    val user: LiveData<UserModel> get() = _user

    fun onCreate() {
        viewModelScope.launch {
            val data = GetUsersUseCase().invoke()
            //ID TEST
            val userData = GetUserUseCase().invoke(5)
            _users.value = data
            _user.value = userData
        }
    }
}