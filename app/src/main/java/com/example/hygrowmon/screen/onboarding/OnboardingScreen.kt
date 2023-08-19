package com.example.hygrowmon.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.hygrowmon.theming.AppColor
import com.example.hygrowmon.viewmodel.onboarding.OnboardingViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<OnboardingViewModel>()
    val scrHeight = LocalConfiguration.current.screenHeightDp
    val topSectionHeight = (scrHeight / 2.5).dp

    HorizontalPager(count = OnboardingData.values().size) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(AppColor.Green)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(topSectionHeight)
                    .clip(RoundedCornerShape(bottomEnd = 32.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp, vertical = 64.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = OnboardingData.values()[it].title,
                            color = Color.Black,
                            fontSize = 18.sp,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Text(
                            text = OnboardingData.values()[it].description,
                            color = Color.Black
                        )
                    }
                }
            }

            Column(
                modifier = Modifier.height((scrHeight - topSectionHeight.value).dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        contentScale = ContentScale.Fit,
                        model = OnboardingData.values()[it].logoId,
                        contentDescription = ""
                    )
                }

                Button(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = if (OnboardingData.values()[it] != OnboardingData.values()
                                .last()
                        ) "Lewati" else "Mulai Sekarang"
                    )
                }
            }
        }
    }
}