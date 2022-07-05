package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.*
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(): ViewModel() {
    private val _users by lazy { MutableLiveData<List<UserModel>>() }
    private val _user by lazy { MutableLiveData<UserModel>() }
    val users: LiveData<List<UserModel>> get() = _users
    val user: LiveData<UserModel> get() = _user

    fun onCreate() {
        viewModelScope.launch {
            val userList = GetUsersUseCase().invoke()
            val imageList = GetImagesUseCase().invoke()
            val finalUserList = AssignImageToUserUseCase().invoke(userList, imageList)
            //ID TEST
            val userData = GetUserUseCase().invoke(5)
            _users.value = finalUserList
            _user.value = userData
        }
    }
}