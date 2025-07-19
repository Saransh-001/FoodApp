package com.example.foodapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.foodapp.R

@Composable
fun FilterDialog(
    onDismiss: () -> Unit,
    onFilterClick: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0x99273F55))
            .zIndex(4f)
            .clickable(onClick = onDismiss)
    ) {
        Box(
            modifier = Modifier
                .width(347.dp)
                .height(649.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                .align(Alignment.Center)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .clickable(enabled = false) {}
        ) {
            Column(
                Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Filter your search",
                        style = TextStyle(
                            fontSize = 17.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.sen)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF181C2E),
                            textAlign = TextAlign.Center,
                        )
                    )
                    Box(
                        modifier = Modifier
                            .width(45.dp)
                            .height(45.dp)
                            .background(
                                color = Color(0x33C8D3D8),
                                shape = RoundedCornerShape(size = 20.dp)
                            )
                            .clickable { onDismiss() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.akar_icons_cross),
                            contentDescription = "image description",
                            tint = Color.Black
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))
                Text(
                    text = "OFFERS",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF32343E),

                        )
                )
                Spacer(Modifier.height(13.dp))
                FilterChips(listOf("Delivery", "Pick Up", "Offer", "Online payment available"))

                Spacer(Modifier.height(32.dp))
                Text(
                    text = "DELIVERY TIME",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF32343E),

                        )
                )
                Spacer(Modifier.height(12.dp))
                SelectableChips(listOf("10-15 min", "20 min", "30 min"))

                Spacer(Modifier.height(32.dp))
                Text(
                    text = "PRICING",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF32343E),

                        )
                )
                Spacer(Modifier.height(12.dp))
                SelectablePricing(listOf("$", "$$", "$$$"))

                Spacer(Modifier.height(32.dp))
                Text(
                    text = "RATING",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF32343E),
                    )
                )
                Spacer(Modifier.height(12.dp))
                RatingRow(selectedRating = 0)

                Spacer(Modifier.height(31.dp))
                Button(
                    onClick = onFilterClick,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(307.dp)
                        .height(62.dp)
                        .background(color = Color(0xFFDCE8FF), shape = RoundedCornerShape(50)),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE6EDFF))
                ) {
                    Text(
                        text = "FILTER",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.sen)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterChips(items: List<String>) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items.forEach { label ->
            Box (
                modifier = Modifier
                    .clickable{}
                    .background(Color.White, shape = RoundedCornerShape(50))
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(50))
                    .padding(15.dp)
            ) {
                Text(
                    text = label,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF464E57)
                    )
                )
            }
        }
    }
}

@Composable
fun SelectableChips(items: List<String>, selectedIndex: Int = 0) {
    var selected by remember { mutableIntStateOf(selectedIndex) }

    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items.forEachIndexed { index, label ->
            Box (
                modifier = Modifier
                    .wrapContentSize()
                    .clickable{ selected = index}
                    .clip(CircleShape)
                    .background(if (selected == index) Color(0xFFE6EDFF) else Color.Transparent, CircleShape)
                    .border(1.dp, Color.LightGray, CircleShape)
                    .padding(15.dp)
            ) {
                Text(
                    text = label,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000)
                    )
                )
            }
        }
    }
}

@Composable
fun SelectablePricing(items: List<String>, selectedIndex: Int = 0) {
    var selected by remember { mutableIntStateOf(selectedIndex) }

    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items.forEachIndexed { index, label ->
            Box (
                modifier = Modifier
                    .size(height = 48.dp, width = 48.dp)
                    .clickable{ selected = index}
                    .background(if (selected == index) Color(0xFFE6EDFF) else Color.Transparent, CircleShape)
                    .border(1.dp, Color.LightGray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000)
                    )
                )
            }
        }
    }
}



@Composable
fun RatingRow(selectedRating: Int) {
    var selected by remember { mutableStateOf(selectedRating) }
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        (1..5).forEach { i ->
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(100)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { selected = i }) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star $i",
                        tint = if (i <= selected) Color(0xFFFFC107) else Color.LightGray
                    )
                }
            }
            Spacer(Modifier.width(4.dp))
        }
    }
}

@Preview
@Composable
fun FilterDialog_Preview() {
    FilterDialog(
        onDismiss = {},
        onFilterClick = {}
    )
}