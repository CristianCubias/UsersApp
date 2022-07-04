package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.*
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(): ViewModel() {
    val _users by lazy { MutableLiveData<List<UserModel>>() }
    val users: LiveData<List<UserModel>> get() = _users

    fun onCreate() {
        viewModelScope.launch {
           val data = GetUsersUseCase().invoke()
            _users.value = data
        }
    }
}