package com.example.hygrowmon.viewmodel.onboarding

import androidx.lifecycle.ViewModel
import com.example.hygrowmon.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
}