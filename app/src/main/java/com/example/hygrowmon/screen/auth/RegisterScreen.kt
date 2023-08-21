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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hygrowmon.component.util.AppTextFieldColors
import com.example.hygrowmon.theming.AppColor
import com.example.hygrowmon.viewmodel.auth.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val viewModel = hiltViewModel<RegisterViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Green)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Text(
                text = "Halo",
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColor.White
            )
            Text(
                text = "Silahkan isi form di bawah untuk daftar",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColor.White
            )
        }

        Column {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.nameState.value,
                onValueChange = {
                    viewModel.nameState.value = it
                },
                label = {
                    Text(text = "Nama Lengkap", color = AppColor.White)
                },
                colors = AppTextFieldColors.outlinedTransparentWhite()
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.noTelpState.value,
                onValueChange = {
                    viewModel.noTelpState.value = it
                },
                label = {
                    Text(text = "No. Telepon", color = AppColor.White)
                },
                leadingIcon = {
                    Text(text = "+62 -", color = AppColor.White)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = AppTextFieldColors.outlinedTransparentWhite()
            )

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

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.confirmPasswordState.value,
                onValueChange = {
                    viewModel.confirmPasswordState.value = it
                },
                label = {
                    Text(text = "Konfirmasi Password", color = AppColor.White)
                },
                visualTransformation = PasswordVisualTransformation(),
                colors = AppTextFieldColors.outlinedTransparentWhite()
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColor.Orange,
                contentColor = AppColor.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Daftar")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Sudah memiliki akun?", color = AppColor.White, fontSize = 12.sp)
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Masuk di sini", color = AppColor.Orange, fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}