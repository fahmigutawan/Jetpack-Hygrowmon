package com.example.hygrowmon.viewmodel.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hygrowmon.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
) :ViewModel(){
    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")

    fun login(
        onSuccess:() -> Unit,
        onFailed:(e:String) -> Unit
    ){
        repository.login(
            email = emailState.value,
            password = passwordState.value,
            onSuccess = onSuccess,
            onFailed = onFailed
        )
    }
}