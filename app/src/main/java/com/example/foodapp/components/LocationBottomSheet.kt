package com.example.foodapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R

@Composable
fun LocationSheetContent(
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 15.dp, top = 28.dp, end = 15.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Location",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF40484E),
                    letterSpacing = 0.6.sp,
                )
            )
            Box(
                modifier = modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(
                        color = Color(0x33C8D3D8),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .clickable { onClose() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.akar_icons_cross),
                    contentDescription = "image description",
                    tint = Color.Black
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        repeat(3) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {}
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .background(
                            color = Color(0x4DC8D3D8),
                            shape = RoundedCornerShape(size = 30.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.mage_location),
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(Modifier.width(15.dp))

                Text(
                    text = "Use my current location",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF40484E),
                    )
                )
            }

            if (it != 2) {
                Divider(
                    Modifier
                        .width(363.dp)
                        .height(1.dp)
                        .background(color = Color(0xCCC8D3D8))
                )
            }
        }

        Spacer(Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun LocationSheetContent_Preview() {
    LocationSheetContent( onClose = {})
}
