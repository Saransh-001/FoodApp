package com.example.foodapp.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R
import com.example.foodapp.components.RoundedIcon

@Composable
fun TopBarIconRow(
    onLocationClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundedIcon(
            painter = painterResource(R.drawable.mdi_location),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .shadow(
                    elevation = 2.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(50.dp)
                .height(50.dp)
                .background(
                    color = Color(0x4DD9D9D9),
                    shape = RoundedCornerShape(size = 25.dp)
                )
                .clickable{ onLocationClick() }
                .padding(13.dp)
        )

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .width(213.dp)
                .height(41.dp)
        ) {
            Text(
                text = "Location",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                )
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "2972 Westheimer Rd. Santa Ana ",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF)
                )
            )
        }

        RoundedIcon(
            painter = painterResource(R.drawable.lineicons_cart),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .shadow(
                    elevation = 2.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(50.dp)
                .height(50.dp)
                .background(
                    color = Color(0x4DD9D9D9),
                    shape = RoundedCornerShape(size = 25.dp)
                )
                .clickable { onCartClick() }
                .padding(13.dp)
        )
    }
}