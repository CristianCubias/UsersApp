package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    //Remote
    private val getUsersUseCase: GetUsersUseCase,
    private val getImagesUseCase: GetImagesUseCase,
    //Local
    private val getUsersFromLocalUseCase: GetUsersFromLocalUseCase,
    private val insertUserIntoDatabaseUseCase: InsertUserIntoDatabaseUseCase,
    private val assignImageToUserUseCase: AssignImageToUserUseCase
): ViewModel() {
    private val _users by lazy { MutableLiveData<List<UserModel>>() }
    val users: LiveData<List<UserModel>> get() = _users

    fun onCreate() {
        viewModelScope.launch(Dispatchers.IO) {
            getUsersUseCase().collect { userList ->
                getImagesUseCase().collect { imageList ->
                    assignImageToUserUseCase(userList, imageList).forEach { user ->
                        insertUserIntoDatabaseUseCase(user)
                    }
                }
            }

            getUsersFromLocalUseCase().collect { data ->
                withContext(Dispatchers.Main) {
                    _users.value = data
                }
            }
        }
    }
}