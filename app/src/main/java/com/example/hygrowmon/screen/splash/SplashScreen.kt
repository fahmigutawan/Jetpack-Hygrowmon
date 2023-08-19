package com.example.hygrowmon.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.hygrowmon.R
import com.example.hygrowmon.routes.Routes
import com.example.hygrowmon.theming.AppColor
import com.example.hygrowmon.viewmodel.splash.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<SplashViewModel>()

    LaunchedEffect(key1 = true) {
        delay(2000)
        viewModel.precheckStatus { isLogin, isFirstTime ->
            if (isLogin) {
                if (isFirstTime) {
                    navController.navigate(Routes.Onboarding.name) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                } else {
                    navController.navigate(Routes.Dashboard.name) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            } else {
                //TODO Go to Auth screen
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Green),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            model = R.drawable.logo,
            contentDescription = ""
        )
    }
}