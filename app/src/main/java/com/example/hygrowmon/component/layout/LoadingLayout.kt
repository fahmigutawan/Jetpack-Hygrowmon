package com.example.hygrowmon.component.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hygrowmon.rootViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoadingLayout(
    modifier:Modifier = Modifier,
    content:@Composable (() -> Unit)
) {
    val loadingState = rememberSwipeRefreshState(
        isRefreshing = rootViewModel.loading.value
    )

    SwipeRefresh(
        modifier = modifier,
        state = loadingState,
        onRefresh = { /*TODO*/ },
        swipeEnabled = false
    ) {
        content()
    }
}