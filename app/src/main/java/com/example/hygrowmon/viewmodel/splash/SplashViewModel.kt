package com.example.hygrowmon.viewmodel.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hygrowmon.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun precheckStatus(
        onChecked:(login:Boolean, firstTime:Boolean) -> Unit
    ){
        viewModelScope.launch {
            onChecked(
                repository.isLogin(),
                repository.getFirstTimeState().last()
            )
        }
    }
}