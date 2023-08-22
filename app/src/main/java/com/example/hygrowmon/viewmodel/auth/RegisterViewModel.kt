package com.example.hygrowmon.viewmodel.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hygrowmon.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: Repository
) :ViewModel(){
    val nameState = mutableStateOf("")
    val noTelpState = mutableStateOf("")
    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val confirmPasswordState = mutableStateOf("")

    fun register(
        onSuccess:() -> Unit,
        onFailed:(String) -> Unit
    ){
        repository.register(
            name = nameState.value,
            noHp = noTelpState.value,
            email = emailState.value,
            password = passwordState.value,
            confirmPassword = confirmPasswordState.value,
            onSuccess = onSuccess,
            onFailed = onFailed
        )
    }
}