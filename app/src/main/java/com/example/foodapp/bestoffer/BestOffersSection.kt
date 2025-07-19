package com.example.foodapp.bestoffer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
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

@Composable
fun BestOffersSection() {
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
                text = "Best Offers",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF40484E)
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

        LazyRow {
            items(5) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .shadow(
                                elevation = 0.dp,
                                spotColor = Color(0x4DC8D3D8),
                                ambientColor = Color(0x4DC8D3D8)
                            )
                            .padding(1.dp)
                            .width(70.dp)
                            .height(70.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(50.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.burger),
                            contentDescription = null,
                            modifier = Modifier
                                .width(55.1769.dp)
                                .height(50.80645.dp)
                                .size(80.dp)
                                .clip(CircleShape)
                        )
                    }

                    Spacer(Modifier.height(5.dp))

                    Text(
                        text = "Burger",
                        style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 14.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),

                            textAlign = TextAlign.Center,
                        )
                    )

                }

                Spacer(Modifier.width(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun BestOffersSection_Preview() {
    BestOffersSection()
}