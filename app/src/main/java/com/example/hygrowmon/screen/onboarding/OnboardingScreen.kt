package com.example.hygrowmon.screen.onboarding

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hygrowmon.viewmodel.onboarding.OnboardingViewModel

@Composable
fun OnboardingScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<OnboardingViewModel>()

}