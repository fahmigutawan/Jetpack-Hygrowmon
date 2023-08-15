package com.example.hygrowmon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hygrowmon.routes.Routes
import okhttp3.Route

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Dashboard.name
    ) {
        composable(Routes.Splash.name){

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
    }
}