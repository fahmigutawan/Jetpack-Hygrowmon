package com.example.hygrowmon.helper

import com.example.hygrowmon.rootViewModel

object LoadingHandler{
    val loading = {
        rootViewModel.loading.value = true
    }

    val dismiss = {
        rootViewModel.loading.value = false
    }
}