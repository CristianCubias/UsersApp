package com.cristian.apptest.ui.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(): ViewModel() {

    fun onCreate() {
        viewModelScope.launch {
            println("Here")
        }
    }
}