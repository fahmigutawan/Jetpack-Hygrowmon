package com.example.hygrowmon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.hygrowmon.component.Navbar
import com.example.hygrowmon.routes.Routes
import com.example.hygrowmon.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val mainViewModel by viewModels<MainViewModel>()

            navController.addOnDestinationChangedListener { _, destination, _ ->
                destination.route?.let {
                    mainViewModel.currentRoute.value = it

                    when(it){
                        Routes.Dashboard.name -> {
                            mainViewModel.showBottomBar.value = true
                        }

                        Routes.Belanja.name -> {
                            mainViewModel.showBottomBar.value = true
                        }

                        Routes.Lahanku.name -> {
                            mainViewModel.showBottomBar.value = true
                        }

                        Routes.Pesan.name -> {
                            mainViewModel.showBottomBar.value = true
                        }

                        Routes.Profil.name -> {
                            mainViewModel.showBottomBar.value = true
                        }

                        else -> {
                            mainViewModel.showBottomBar.value = false
                        }
                    }
                }
            }

            Scaffold(
                bottomBar = {
                    if (mainViewModel.showBottomBar.value) {
                        Navbar(
                            onItemClicked = { navController.navigate(it) },
                            currentRoute = mainViewModel.currentRoute.value
                        )
                    }
                }
            ) {
                MainNavHost(
                    modifier = Modifier
                        .padding(
                            bottom = it.calculateBottomPadding()
                        ),
                    navController = navController
                )
            }
        }
    }
}