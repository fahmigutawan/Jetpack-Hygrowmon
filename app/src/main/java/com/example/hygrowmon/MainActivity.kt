package com.example.hygrowmon

import android.os.Bundle
import android.provider.DocumentsContract.Root
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.hygrowmon.component.Navbar
import com.example.hygrowmon.component.layout.LoadingLayout
import com.example.hygrowmon.routes.Routes
import com.example.hygrowmon.viewmodel.MainViewModel
import com.example.hygrowmon.viewmodel.RootViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

lateinit var rootViewModel: RootViewModel
lateinit var showSnackbar: (message: String) -> Unit
lateinit var showSnackbarWithAction: (
    message: String,
    actionLabel: String,
    action: () -> Unit
) -> Unit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val snackbarHostState = remember { SnackbarHostState() }
            val mainViewModel by viewModels<MainViewModel>()
            val coroutineScope = rememberCoroutineScope()

            rootViewModel = viewModel()
            showSnackbar = {
                coroutineScope.launch(Dispatchers.IO) {
                    snackbarHostState.currentSnackbarData?.dismiss()
                    snackbarHostState.showSnackbar(it)
                }
            }
            showSnackbarWithAction = { msg, label, action ->
                coroutineScope.launch(Dispatchers.IO) {
                    snackbarHostState.currentSnackbarData?.dismiss()
                    val snackbarData = snackbarHostState
                        .showSnackbar(
                            message = msg,
                            actionLabel = label
                        )

                    if (snackbarData == SnackbarResult.ActionPerformed) {
                        if (label == "Tutup") {
                            snackbarHostState.currentSnackbarData?.dismiss()
                        } else {
                            action()
                        }
                    }
                }
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                destination.route?.let {
                    mainViewModel.currentRoute.value = it

                    when (it) {
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
                snackbarHost = {
                    SnackbarHost(hostState = snackbarHostState)
                },
                bottomBar = {
                    if (mainViewModel.showBottomBar.value) {
                        Navbar(
                            onItemClicked = { navController.navigate(it) },
                            currentRoute = mainViewModel.currentRoute.value
                        )
                    }
                }
            ) {
                LoadingLayout {
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
}