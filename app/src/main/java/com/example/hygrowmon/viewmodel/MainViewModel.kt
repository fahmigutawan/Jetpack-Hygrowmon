package com.example.hygrowmon.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hygrowmon.routes.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() :ViewModel(){
    val currentRoute = mutableStateOf(Routes.Splash.name)
    val showBottomBar = mutableStateOf(false)
}