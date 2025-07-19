package com.example.foodapp.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R

@Composable
fun TopBarSection(
    onLocationClick: () -> Unit,
    onCartClick: () -> Unit,
    onFilterClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .width(393.dp)
            .height(289.dp)
            .background(
                color = Color(0xFF002C56),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(22.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(top = 40.dp)
        ) {
            TopBarIconRow(
                onLocationClick = onLocationClick,
                onCartClick = onCartClick
            )

            Text(
                text = "What are you going \nto eat today?",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.inria_serif)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF)
                ),
                modifier = Modifier
                    .width(273.dp)
                    .height(72.dp)
            )

            SearchBarSection(onFilterClick)
        }
    }
}

@Preview
@Composable
fun TopBarSection_Preview() {
    TopBarSection(
        onLocationClick ={},
        onCartClick = {},
        onFilterClick = {}
    )
}