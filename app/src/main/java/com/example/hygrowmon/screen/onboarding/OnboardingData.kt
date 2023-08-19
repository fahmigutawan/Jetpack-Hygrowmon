package com.example.hygrowmon.screen.onboarding

import com.example.hygrowmon.R

enum class OnboardingData(
    val title:String,
    val description:String,
    val logoId:Int
) {
    Page1(
        "Belanja produk hidroponik dengan mudah dan cepat",
        "Temukan ribuan produk hidroponik mulai dari media tanam hingga benih dengan harga yang bersaing",
        R.drawable.onboarding1
    ),
    Page2(
        "Ketahui status terkini lahan hidroponikmu",
        "Dapatkan terus update informasi tanamanmu melalui alat yang terpasang! Tak perlu khawatir tanaman tidak terawat ",
        R.drawable.onboarding2
    ),
    Page3(
        "Konsultasikan perawatan tanamanmu dengan mudah",
        "Ketahui beberapa informasi penting terkait dengan perawatan tanaman pertanian berkonsep hidroponik",
        R.drawable.onboarding3
    )
}