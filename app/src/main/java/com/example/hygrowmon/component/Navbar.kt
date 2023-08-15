package com.example.hygrowmon.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.hygrowmon.R
import com.example.hygrowmon.routes.Routes
import com.example.hygrowmon.theming.Color

enum class NavbarItem(
    val route: String,
    val word: String,
    val logoId: Int
) {
    Dashboard(
        Routes.Dashboard.name,
        "Dashboard",
        R.drawable.navbar_dashboard
    ),
    Lahanku(
        Routes.Lahanku.name,
        "Lahanku",
        R.drawable.navbar_lahanku
    ),
    Belanja(
        Routes.Belanja.name,
        "Belanja",
        R.drawable.navbar_belanja
    ),
    Pesan(
        Routes.Pesan.name,
        "Pesan",
        R.drawable.navbar_chat
    ),
    Profil(
        Routes.Profil.name,
        "Profil",
        R.drawable.navbar_profil
    )
}

@Composable
fun Navbar(
    onItemClicked: (String) -> Unit,
    currentRoute: String
) {
    val containerWidth = remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    BottomAppBar {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .onSizeChanged {
                    density.run {
                        containerWidth.value = it.width.toDp()
                    }
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NavbarItem.values().forEach {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable(
                            onClick = {
                                onItemClicked(it.route)
                            },
                            indication = rememberRipple(),
                            interactionSource = MutableInteractionSource()
                        )
                        .width(containerWidth.value / NavbarItem.values().size),
                    contentAlignment = Center
                ) {
                    Column(
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            painter = rememberAsyncImagePainter(model = it.logoId),
                            contentDescription = "",
                            tint = if (currentRoute == it.route) Color.Green else Color.DarkGrey
                        )
                        Text(
                            text = it.word,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp,
                            color = if (currentRoute == it.route) Color.Green else Color.DarkGrey
                        )
                    }
                }
            }
        }
    }
}