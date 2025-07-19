package com.example.foodapp.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.navbar.Destination
import kotlin.collections.forEachIndexed

@Composable
fun CustomBottomNavBar(
    modifier: Modifier = Modifier
) {

    val startDestination = Destination.HOME
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Row(
        modifier = modifier
            .width(363.dp)
            .height(65.dp)
            .background(color = Color(0xFF000000), shape = RoundedCornerShape(size = 30.dp))
            .shadow(8.dp, RoundedCornerShape(50))
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Destination.entries.forEachIndexed { index, destination ->
            val isSelected = index == selectedDestination
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) Color.White else Color.Transparent)
                    .clickable { selectedDestination = index },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(destination.icon),
                    contentDescription = destination.contentDescription,
                    tint = if (isSelected) Color.Black else Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomBottomNavBar_Preview() {
    CustomBottomNavBar()
}