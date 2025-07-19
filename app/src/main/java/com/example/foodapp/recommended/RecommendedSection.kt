package com.example.foodapp.recommended

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.example.foodapp.components.OutlineButton
import com.example.foodapp.sample_data.SampleData
import com.example.foodapp.sample_data.model.Food

@Composable
fun RecommendedSection(
    foodList: List<Food>
) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 17.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recommended for you",
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

        Spacer(Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            OutlineButton(
                icon1 = R.drawable.mage_filter,
                text = "Filter",
                icon2 = R.drawable.weui_arrow_outlined
            )

            OutlineButton(text = "Fast delivery")

            OutlineButton(text = "Try Something new")
        }

        Spacer(Modifier.height(15.dp))

        Column {
            foodList.forEach { food ->
                FoodCard(food)
                Spacer(Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun FoodCard(
    foodItem: Food
) {
    Row(
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x4D000000),
                ambientColor = Color(0x4D000000)
            )
            .width(353.dp)
            .height(142.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 20.dp))
            .padding(start = 7.dp, top = 6.dp, end = 12.dp, bottom = 6.dp)
    ) {

            Image(
                painter = painterResource(id = foodItem.image),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(100.dp)
                    .height(130.dp)
                    .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 15.dp))
                    .clip(RoundedCornerShape(size = 15.dp))
            )

            Spacer(Modifier.width(11.dp))

            Column(
                modifier = Modifier
                    .width(228.dp)
                    .height(130.dp)
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Cheese burger",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )

                    RatingCard(
                        rating = foodItem.rating
                    )
                }

                Spacer(Modifier.height(7.dp))

                Text(
                    text = foodItem.description,
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )

                Spacer(Modifier.height(7.dp))

                Text(
                    text = foodItem.time,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(10.dp))

                AddToCartButton(onClick = foodItem.onClick)
            }



    }
}

@Composable
fun AddToCartButton(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .width(72.dp)
            .height(20.dp)
            .background(color = Color(0xFFFDD835), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
            .clickable(
                onClick = { onClick() }
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.lineicons_cart_1),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )

        Spacer(Modifier.width(5.dp))

        Text(
            text = "Add to cart",
            style = TextStyle(
                fontSize = 8.sp,
                lineHeight = 10.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                letterSpacing = 0.16.sp,
            )
        )
    }
}

@Composable
fun RatingCard(
    rating: Float,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .width(38.dp)
            .height(20.dp)
            .background(color = Color(0xFFFDD835), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.material_symbols_star),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )

        Spacer(Modifier.width(5.dp))

        Text(
            text = rating.toString(),
            style = TextStyle(
                fontSize = 8.sp,
                lineHeight = 10.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                letterSpacing = 0.16.sp,
            )
        )
    }
}

@Preview
@Composable
fun FoodCard_Preview() {
    FoodCard(
        Food(
            title = "Cheese Burger",
            description = "A cheeseburger is a hamburger with one or more slices of melted cheese on top .",
            image = R.drawable.burger2,
            rating = 4.9f,
            time = "20 min",
            onClick = {}
        )
    )
}

@Preview
@Composable
fun RecommendedSection_Preview() {
    RecommendedSection(
        foodList = SampleData.foodList
    )
}