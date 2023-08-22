package com.example.hygrowmon.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hygrowmon.component.util.AppTextFieldColors
import com.example.hygrowmon.helper.LoadingHandler
import com.example.hygrowmon.helper.SnackbarHandler
import com.example.hygrowmon.routes.Routes
import com.example.hygrowmon.theming.AppColor
import com.example.hygrowmon.viewmodel.auth.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val viewModel = hiltViewModel<LoginViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Green)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Hygrowmon",
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColor.White,
                textAlign = TextAlign.Center
            )
        }

        Column {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.emailState.value,
                onValueChange = {
                    viewModel.emailState.value = it
                },
                label = {
                    Text(text = "Email", color = AppColor.White)
                },
                colors = AppTextFieldColors.outlinedTransparentWhite()
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.passwordState.value,
                onValueChange = {
                    viewModel.passwordState.value = it
                },
                label = {
                    Text(text = "Password", color = AppColor.White)
                },
                visualTransformation = PasswordVisualTransformation(),
                colors = AppTextFieldColors.outlinedTransparentWhite()
            )
        }

        Column {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    LoadingHandler.loading()
                    viewModel.login(
                        onSuccess = {
                            LoadingHandler.dismiss()
                            SnackbarHandler.showSnackbar(message = "Sukses")
                        },
                        onFailed = {
                            LoadingHandler.dismiss()
                            SnackbarHandler.showSnackbar(it)
                        }
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColor.Orange,
                    contentColor = AppColor.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Masuk")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Belum memiliki akun?", color = AppColor.White, fontSize = 12.sp)
                TextButton(onClick = {
                    navController.navigate(Routes.Register.name)
                }) {
                    Text(text = "Daftar di sini", color = AppColor.Orange, fontSize = 12.sp)
                }
            }
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}