package com.example.hygrowmon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.hygrowmon.component.Navbar
import com.example.hygrowmon.routes.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    Navbar(
                        onItemClicked = {
                        },
                        currentRoute = Routes.Dashboard.name
                    )
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