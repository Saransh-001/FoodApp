package com.example.foodapp.sample_data.model

data class Food(
    val title: String,
    val description: String,
    val image: Int,
    val rating: Float,
    val time: String,
    val onClick: () -> Unit
)
