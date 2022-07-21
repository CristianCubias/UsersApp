package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.*
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    //Remote
    private val getUsersUseCase: GetUsersUseCase,
    private val getImagesUseCase: GetImagesUseCase,
    private val assignImageToUserUseCase: AssignImageToUserUseCase,
    //Local
    private val getUsersFromLocalUseCase: GetUsersFromLocalUseCase,
    private val getUserFromLocalUseCase: GetUserFromLocalUseCase,
    private val insertUserIntoDatabaseUseCase: InsertUserIntoDatabaseUseCase
): ViewModel() {
    //User list
    private val users: MutableLiveData<List<UserModel>> by lazy { MutableLiveData<List<UserModel>>().also { loadUsers() } }
    //Individual user
    private val _user: MutableLiveData<UserModel> by lazy { MutableLiveData<UserModel>() }
    val user: LiveData<UserModel> get() = _user

    private fun loadUsers() {
        //Exception handling
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            try {
                getUsersUseCase().collect { userList ->
                    getImagesUseCase().collect { imageList ->
                        assignImageToUserUseCase(userList, imageList).forEach { user ->
                            insertUserIntoDatabaseUseCase(user)
                        }
                    }
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }

            getUsersFromLocalUseCase().collect { data ->
                withContext(Dispatchers.Main) {
                    users.value = data
                }
            }
        }
    }
    fun getUsers(): LiveData<List<UserModel>> { return users }
    fun getUser(userID: Int): LiveData<UserModel>
    {
        viewModelScope.launch(Dispatchers.IO) {
            getUserFromLocalUseCase(userID).collect { data ->
                withContext(Dispatchers.Main) {
                    _user.value = data
                }
            }
        }
        return user
    }
}