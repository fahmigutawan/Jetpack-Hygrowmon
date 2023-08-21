package com.example.hygrowmon.component.util

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import com.example.hygrowmon.theming.AppColor

object AppTextFieldColors {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun outlinedTransparentWhite():TextFieldColors {
        return TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = AppColor.White,
            unfocusedBorderColor = AppColor.LightBrown,
            focusedLabelColor = AppColor.White,
            unfocusedLabelColor = AppColor.LightBrown,
            textColor = AppColor.White,
            cursorColor = AppColor.White
        )
    }
}