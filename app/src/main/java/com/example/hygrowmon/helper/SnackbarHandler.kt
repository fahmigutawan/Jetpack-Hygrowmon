package com.example.hygrowmon.helper

import androidx.compose.runtime.Composable

object SnackbarHandler {
    fun showSnackbar (
        message: String
    ) {
        com.example.hygrowmon.showSnackbar(message)
    }

    fun showSnackbarWithAction(
        message: String,
        actionLabel:String = "Tutup",
        action:() -> Unit
    ){
        com.example.hygrowmon.showSnackbarWithAction(
            message,
            actionLabel,
            action
        )
    }
}