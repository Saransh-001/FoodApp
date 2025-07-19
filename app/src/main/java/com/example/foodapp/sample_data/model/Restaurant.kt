package com.example.foodapp.sample_data.model

data class Restaurant(
    val name: String,
    val rating: Float,
    val timeToDelivery: String,
    val image: Int,
    val onClick: () -> Unit,
    val isDeliveryFree: Boolean
)
