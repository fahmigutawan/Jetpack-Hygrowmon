package com.example.hygrowmon.viewmodel.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hygrowmon.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun setFistTimeState(
        onFinished:() -> Unit
    ){
        viewModelScope.launch {
            repository.setFirstTimeState(false)
            delay(1000)
            onFinished()
        }
    }

    fun isLogin() = repository.isLogin()
}