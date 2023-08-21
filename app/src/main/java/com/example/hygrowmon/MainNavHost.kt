package com.example.hygrowmon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hygrowmon.routes.Routes
import com.example.hygrowmon.screen.auth.LoginScreen
import com.example.hygrowmon.screen.auth.RegisterScreen
import com.example.hygrowmon.screen.onboarding.OnboardingScreen
import com.example.hygrowmon.screen.splash.SplashScreen
import okhttp3.Route

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Splash.name
    ) {
        composable(Routes.Splash.name){
            SplashScreen(navController = navController)
        }

        composable(Routes.Onboarding.name){
            OnboardingScreen(navController = navController)
        }

        composable(Routes.Dashboard.name){

        }

        composable(Routes.Lahanku.name){

        }

        composable(Routes.Belanja.name){

        }

        composable(Routes.Pesan.name){

        }

        composable(Routes.Profil.name){

        }

        composable(Routes.Login.name){
            LoginScreen(navController = navController)
        }

        composable(Routes.Register.name){
            RegisterScreen(navController = navController)
        }
    }
}