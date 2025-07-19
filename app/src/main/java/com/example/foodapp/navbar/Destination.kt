package com.example.foodapp.navbar

import com.example.foodapp.R

enum class Destination(
    val icon: Int,
    val contentDescription: String? = null
) {
    HOME(icon = R.drawable.streamline_plump_home_1),
    HISTORY(icon = R.drawable.material_symbols_history),
    SUPPORT(icon = R.drawable.ix_support),
    PROFILE(icon = R.drawable.iconamoon_profile)
}