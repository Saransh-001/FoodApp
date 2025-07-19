package com.example.foodapp.sample_data

import android.R.attr.onClick
import com.example.foodapp.R
import com.example.foodapp.sample_data.model.Food
import com.example.foodapp.sample_data.model.Restaurant
import com.example.foodapp.sample_data.model.TodayOffer

class SampleData {
    companion object {
        val todayOffersList = listOf(
            TodayOffer("Buy 1 get 1 Free", icon = R.drawable.frame_13),
            TodayOffer("Buy 1 get 1 Free", icon = R.drawable.frame_13),
            TodayOffer("Buy 1 get 1 Free", icon = R.drawable.frame_13)
        )

        val foodList = listOf(
            Food(
                title = "Cheese Burger",
                description = "A cheeseburger is a hamburger with one or more slices of melted cheese on top .",
                image = R.drawable.burger2,
                rating = 4.9f,
                time = "20 min",
                onClick = {}
            ),
            Food(
                title = "Cheese Burger",
                description = "A cheeseburger is a hamburger with one or more slices of melted cheese on top .",
                image = R.drawable.burger2,
                rating = 4.9f,
                time = "20 min",
                onClick = {}
            ),
            Food(
                title = "Cheese Burger",
                description = "A cheeseburger is a hamburger with one or more slices of melted cheese on top .",
                image = R.drawable.burger2,
                rating = 4.9f,
                time = "20 min",
                onClick = {}
            ),
            Food(
                title = "Cheese Burger",
                description = "A cheeseburger is a hamburger with one or more slices of melted cheese on top .",
                image = R.drawable.burger2,
                rating = 4.9f,
                time = "20 min",
                onClick = {}
            )
        )

        val restaurantList = listOf(
            Restaurant(
                name = "Restaurant Name",
                rating = 4.8f,
                timeToDelivery = "20 -25 min",
                image = R.drawable.restaurant,
                onClick = {},
                isDeliveryFree = true
            ),
            Restaurant(
                name = "Restaurant Name",
                rating = 4.8f,
                timeToDelivery = "20 -25 min",
                image = R.drawable.restaurant,
                onClick = {},
                isDeliveryFree = true
            ),
            Restaurant(
                name = "Restaurant Name",
                rating = 4.8f,
                timeToDelivery = "20 -25 min",
                image = R.drawable.restaurant,
                onClick = {},
                isDeliveryFree = true
            ),
            Restaurant(
                name = "Restaurant Name",
                rating = 4.8f,
                timeToDelivery = "20 -25 min",
                image = R.drawable.restaurant,
                onClick = {},
                isDeliveryFree = true
            ),
            Restaurant(
                name = "Restaurant Name",
                rating = 4.8f,
                timeToDelivery = "20 -25 min",
                image = R.drawable.restaurant,
                onClick = {},
                isDeliveryFree = true
            ),
            Restaurant(
                name = "Restaurant Name",
                rating = 4.8f,
                timeToDelivery = "20 -25 min",
                image = R.drawable.restaurant,
                onClick = {},
                isDeliveryFree = true
            )
        )
    }
}