package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.*
import com.cristian.apptest.data.UserRepository
import com.cristian.apptest.data.di.NetworkModule
import com.cristian.apptest.data.model.ImageModel
import com.cristian.apptest.data.model.UserModel
import com.cristian.apptest.data.network.RetrofitService
import com.cristian.apptest.domain.GetImagesUseCase
import com.cristian.apptest.domain.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(): ViewModel() {

    //--------------------- POR FAVOR, REVISAR ESTO ---------------------
    private val getUserUseCase = GetUserUseCase(UserRepository(RetrofitService(NetworkModule)))
    private val getImagesUseCase = GetImagesUseCase(UserRepository(RetrofitService(NetworkModule)))
    //-------------------------------------------------------------------

    private val _userModel by lazy { MutableLiveData<List<UserModel>>() }
    private val _images by lazy { MutableLiveData<List<ImageModel>>() }
    val userModel: LiveData<List<UserModel>> get() = _userModel
    val imagesModel: LiveData<List<ImageModel>> get() = _images

    fun onCreate() {
        viewModelScope.launch {
            val users = getUserUseCase.getUsers()
            val images = getImagesUseCase.getImages()
            if(users.isNotEmpty()){
                _userModel.value = users
            }
            if(images.isNotEmpty()){
                _images.value = images
            }
        }
    }
}