package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.*
import com.cristian.apptest.domain.models.ImageModel
import com.cristian.apptest.domain.models.UserModel
import com.cristian.apptest.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    //Remote
    private val getUsersUseCase: GetUsersUseCase,
    private val getImagesUseCase: GetImagesUseCase,
    //Local
    private val getUsersFromLocalUseCase: GetUsersFromLocalUseCase,
    private val getUserFromLocalUseCase: GetUserFromLocalUseCase,
    private val getImagesFromLocalUseCase: GetImagesFromLocalUseCase,
    private val getImageFromLocalUseCase: GetImageFromLocalUseCase,
    private val insertUserIntoDatabaseUseCase: InsertUserIntoDatabaseUseCase,
    private val insertImageIntoDatabaseUseCase: InsertImageIntoDatabaseUseCase,
    //Misc
    private val assignImageToUserUseCase: AssignImageToUserUseCase
): ViewModel() {
    private val _users by lazy { MutableLiveData<List<UserModel>>() }
    private val _images by lazy { MutableLiveData<List<ImageModel>>() }
    val users: LiveData<List<UserModel>> get() = _users
    val images: LiveData<List<ImageModel>> get() = _images

    fun onCreate() {
        viewModelScope.launch {
            val userList = getUsersUseCase.invoke()
            val imageList = getImagesUseCase.invoke()
            val finalUserList = assignImageToUserUseCase.invoke(userList, imageList)
            finalUserList.map { user ->
                insertUserIntoDatabaseUseCase.invoke(user)
            }
            imageList.map { image ->
                insertImageIntoDatabaseUseCase.invoke(image)
            }

            _users.value = getUsersFromLocalUseCase.invoke()
            _images.value = getImagesFromLocalUseCase.invoke()
        }

    }
}