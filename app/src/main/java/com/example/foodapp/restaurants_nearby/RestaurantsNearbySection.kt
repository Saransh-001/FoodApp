package com.example.foodapp.restaurants_nearby

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R
import com.example.foodapp.sample_data.SampleData
import com.example.foodapp.sample_data.model.Restaurant

@Composable
fun RestaurantsNearbySection(
    restaurantList1: List<Restaurant>,
    restaurantList2: List<Restaurant>
) {
    Column(
        modifier = Modifier
            .padding(start = 32.dp, top = 37.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 17.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Restaurants Nearby",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF40484E),
                )
            )


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "See all",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF40484E),
                        textAlign = TextAlign.Center,
                    )
                )

                Spacer(Modifier.width(4.dp))

                Image(
                    painter = painterResource(id = R.drawable.ion_chevron_forward_outline),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(16.dp)
                        .height(16.dp)
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        RestaurantRow(restaurantList1)
        Spacer(Modifier.height(16.dp))
        RestaurantRow(restaurantList2)
    }
}

@Composable
fun RestaurantRow(
    restaurants: List<Restaurant>
) {
    LazyRow {
        items(restaurants) { rest ->
            RestaurantCard(rest)

            Spacer(Modifier.width(20.dp))
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant) {
    Column(
        modifier = Modifier
            .width(155.dp)
            .height(173.dp)
    ) {
        Image(
            painter = painterResource(id = restaurant.image),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(155.dp)
                .height(93.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = restaurant.name,
            style = TextStyle(
                fontSize = 15.5.sp,
                lineHeight = 18.09.sp,
                fontFamily = FontFamily(Font(R.font.manrope)),
                fontWeight = FontWeight(600),
                color = Color(0xFF40484E),
            )
        )

        Spacer(Modifier.height(7.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ion_star),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Spacer(Modifier.width(5.dp))

            Text(
                text = restaurant.rating.toString(),
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 9.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF40484E),
                )
            )

            Text(" | ", fontSize = 17.sp)

            Image(
                painter = painterResource(id = R.drawable.material_symbols_timer_outline),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Spacer(Modifier.width(5.dp))

            Text(
                text = "20 -25 min",
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF40484E),
                ),
                modifier = Modifier
                    .width(129.dp)
                    .height(19.dp)
            )
        }

        if (restaurant.isDeliveryFree) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.solar_delivery_bold_duotone),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = "Free delivery",
                    style = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 9.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF40484E),
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun RestaurantCard_Preview() {
    RestaurantCard(
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

@Preview
@Composable
fun RestaurantsNearbySection_Preview() {
    RestaurantsNearbySection(
        restaurantList1 = SampleData.restaurantList,
        restaurantList2 = SampleData.restaurantList
    )
}