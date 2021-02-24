package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _isLoggedIn.value = false
    }

    fun logIn() {
        _isLoggedIn.value = true
    }

    fun logOut() {
        _isLoggedIn.value = false;
    }


}