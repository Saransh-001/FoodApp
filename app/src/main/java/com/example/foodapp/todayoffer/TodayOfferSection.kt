package com.example.foodapp.todayoffer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R
import com.example.foodapp.sample_data.SampleData
import com.example.foodapp.sample_data.model.TodayOffer

@Composable
fun TodayOfferSection(
    todayOffersList: List<TodayOffer>
) {
    Column(Modifier.padding(start = 20.dp, top = 15.dp)) {
        Text(
            text = "Today offer!",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(500),
                color = Color(0xFF40484E)

            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            items(todayOffersList) { offer ->
                TodayOfferCard(offer)
            }
        }
    }
}

@Composable
fun TodayOfferCard(offer: TodayOffer) {
    Box(
        modifier = Modifier
            .width(327.dp)
            .height(100.dp)
            .background(color = Color(0xFF002C56), shape = RoundedCornerShape(size = 10.dp)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = offer.icon),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                alignment = Alignment.BottomEnd
            )
        }

        Column(
            modifier = Modifier
                .width(120.dp)
                .padding(start = 25.dp)
        ) {
            Text(
                text = offer.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF)
                )
            )

            Spacer(modifier = Modifier.height(7.dp))

            Box(
                modifier = Modifier
                    .width(91.dp)
                    .height(25.dp)
                    .background(color = Color(0xFFFFA500), shape = RoundedCornerShape(size = 30.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Order now",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier
                        .width(65.dp)
                        .height(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TodayOfferSection_Preview() {
    TodayOfferSection(SampleData.todayOffersList)
}