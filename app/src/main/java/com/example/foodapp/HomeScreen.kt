package com.example.foodapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.foodapp.bestoffer.BestOffersSection
import com.example.foodapp.components.FilterDialog
import com.example.foodapp.components.LocationSheetContent
import com.example.foodapp.navbar.CustomBottomNavBar
import com.example.foodapp.recommended.RecommendedSection
import com.example.foodapp.restaurants_nearby.RestaurantsNearbySection
import com.example.foodapp.sample_data.SampleData
import com.example.foodapp.todayoffer.TodayOfferSection
import com.example.foodapp.topbar.TopBarSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var showLocationSheet by remember { mutableStateOf(false) }
    var showFilterDialog by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAFAFA))
        ) {
            item {
                TopBarSection(
                    onLocationClick = { showLocationSheet = true },
                    onCartClick = {},
                    onFilterClick = { showFilterDialog = true }
                )
            }
            item { TodayOfferSection(SampleData.todayOffersList) }
            item { BestOffersSection() }
            item { RecommendedSection(SampleData.foodList) }
            item {
                RestaurantsNearbySection(
                    SampleData.restaurantList,
                    SampleData.restaurantList
                )
                Spacer(modifier = Modifier.height(85.dp))
            }
        }

        if (showLocationSheet) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        showLocationSheet = false
                    }
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .zIndex(0.4f)
                        .fillMaxWidth()
                        .height(405.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0x1A000000),
                                    Color(0x0D000000),
                                    Color.Transparent
                                ),
                                startY = 0f,
                                endY = 400f
                            ),
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                )

                Box(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .zIndex(0.5f)
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x40000000),
                            ambientColor = Color(0x40000000)
                        )
                        .width(393.dp)
                        .height(401.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .pointerInput(Unit) {}
                ) {
                    LocationSheetContent(
                        onClose = { showLocationSheet = false }
                    )
                }
            }
        }


        if (showFilterDialog) {
            FilterDialog(
                onDismiss = { showFilterDialog = false },
                onFilterClick = {}
            )
        }

        CustomBottomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
                .zIndex(1f)
        )
    }
}

@Preview
@Composable
fun HomeScreen_Preview() {
    HomeScreen()
}